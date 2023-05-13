package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_ASSET;
import static io.metaloom.loom.db.model.perm.Permission.READ_ASSET;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_ASSET;

import java.util.UUID;

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
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.utils.hash.SHA512Sum;

@Singleton
public class AssetEndpointService extends AbstractCRUDEndpointService<AssetDao, Asset, SHA512Sum> {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpointService.class);

	@Inject
	public AssetEndpointService(AssetDao assetDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(assetDao, daos, modelBuilder);
	}

	public void delete(LoomRoutingContext lrc, SHA512Sum uuid) {
		delete(lrc, uuid);
	}

	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_ASSET, () -> {
			SHA512Sum from = SHA512Sum.fromString(lrc.pathParam("from"));
			return dao().loadPage(from, lrc.pageSize());
		}, modelBuilder::toAssetList);
	}

	public void load(LoomRoutingContext lrc, SHA512Sum sha512sum) {
		load(lrc, READ_ASSET, () -> {
			Asset asset = dao().load(sha512sum);
			return asset;
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, SHA512Sum id) {
		update(lrc, UPDATE_ASSET, () -> {
			Asset asset = dao().load(id);
			// TODO Update
			return dao().update(asset);
		}, modelBuilder::toResponse);
	}

	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_ASSET, () -> {
			AssetCreateRequest request = lrc.requestBody(AssetCreateRequest.class);
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
