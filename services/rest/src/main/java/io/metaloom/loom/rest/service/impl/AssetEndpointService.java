package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_ASSET;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_ASSET;
import static io.metaloom.loom.db.model.perm.Permission.READ_ASSET;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_ASSET;

import java.util.UUID;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;
import io.metaloom.utils.UUIDUtils;
import io.metaloom.utils.hash.SHA512Sum;

@Singleton
public class AssetEndpointService extends AbstractCRUDEndpointService<AssetDao, Asset> {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpointService.class);

	@Inject
	public AssetEndpointService(AssetDao assetDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(assetDao, daos, modelBuilder, validator);
	}

	public void delete(LoomRoutingContext lrc, String sha512orUUID) {
		if (UUIDUtils.isUUID(sha512orUUID)) {
			delete(lrc, UUID.fromString(sha512orUUID));
		} else {
			SHA512Sum sha512 = SHA512Sum.fromString(sha512orUUID);
			delete(lrc, DELETE_ASSET, () -> {
				return dao().loadBySHA512(sha512);
			});
		}
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_ASSET, id);
	}

	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_ASSET, () -> {
			UUID from = UUID.fromString(lrc.pathParam("from"));
			return dao().loadPage(from, lrc.pageSize(), null);
		}, modelBuilder::toAssetList);
	}

	public void load(LoomRoutingContext lrc, String sha512orUUID) {
		if (UUIDUtils.isUUID(sha512orUUID)) {
			load(lrc, UUID.fromString(sha512orUUID));
		} else {
			SHA512Sum sha512 = SHA512Sum.fromString(sha512orUUID);
			load(lrc, () -> {
				return dao().loadBySHA512(sha512);
			});
		}
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID uuid) {
		load (lrc , () -> {
			return dao().load(uuid);
		});
	}
	
	private void load(LoomRoutingContext lrc, Supplier<Asset> loader) {
		load(lrc, READ_ASSET, () -> {
			return loader.get();
		}, modelBuilder::toResponse);
	}

	public void update(LoomRoutingContext lrc, String sha512orUUID) {
		if (UUIDUtils.isUUID(sha512orUUID)) {
			update(lrc, UUID.fromString(sha512orUUID));
		} else {
			update(lrc, () -> {
				return dao().loadBySHA512(SHA512Sum.fromString(sha512orUUID));
			});
		}
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		update(lrc, () -> {
			return dao().load(uuid);
		});
	}

	protected void update(LoomRoutingContext lrc, Supplier<Asset> loader) {
		update(lrc, UPDATE_ASSET, () -> {
			AssetUpdateRequest request = lrc.requestBody(AssetUpdateRequest.class);
			validator.validate(request);

			Asset asset = loader.get();
			// TODO Update
			return dao().update(asset);
		}, modelBuilder::toResponse);
	}

	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_ASSET, () -> {
			AssetCreateRequest request = lrc.requestBody(AssetCreateRequest.class);
			validator.validate(request);

			UUID userUuid = lrc.userUuid();
			String sha512sumStr = request.getHashes().getSha512();
			SHA512Sum sha512sum = SHA512Sum.fromString(sha512sumStr);
			String mimeType = request.getMimeType();
			String initialOrigin = request.getOrigin();
			Long size = request.getSize();
			return dao().createAsset(userUuid, sha512sum, mimeType, initialOrigin, size);
		}, modelBuilder::toResponse);
	}

}
