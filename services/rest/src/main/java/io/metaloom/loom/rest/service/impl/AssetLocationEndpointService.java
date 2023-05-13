package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_ASSET_LOCATION;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_ASSET_LOCATION;
import static io.metaloom.loom.db.model.perm.Permission.READ_ASSET_LOCATION;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_ASSET_LOCATION;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.asset.AssetLocation;
import io.metaloom.loom.db.model.asset.AssetLocationDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.asset.location.LocationCreateRequest;
import io.metaloom.loom.rest.model.asset.location.LocationFilesystemInfo;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class AssetLocationEndpointService extends AbstractCRUDEndpointService<AssetLocationDao, AssetLocation, UUID> {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpointService.class);

	@Inject
	public AssetLocationEndpointService(AssetLocationDao assetLocationDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(assetLocationDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID uuid) {
		delete(lrc, DELETE_ASSET_LOCATION, uuid);
	}

	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_ASSET_LOCATION, () -> {
			LocationCreateRequest request = lrc.requestBody(LocationCreateRequest.class);

			if (request.getFilesystem() != null) {
				LocationFilesystemInfo fsInfo = request.getFilesystem();
				String path = fsInfo.getPath();
				UUID creatorUuid = lrc.loomUser().getUuid();
				UUID assetUuid = null;
				UUID libraryUuid = null;
				AssetLocation location = dao().createAssetLocation(path, assetUuid, creatorUuid, libraryUuid);
				return location;
			} else if (request.getS3() != null) {
				lrc.error("S3 support not yet implemented");
				return null;
			} else {
				lrc.error("Unknown location information");
				return null;
			}
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		update(lrc, UPDATE_ASSET_LOCATION, () -> {
			AssetLocation location = dao().load(uuid);
			// TODO update
			return dao().update(location);
		}, modelBuilder::toResponse);
	}

	public void load(LoomRoutingContext lrc, UUID uuid) {
		load(lrc, READ_ASSET_LOCATION, () -> {
			return dao().load(uuid);
		}, modelBuilder::toResponse);
	}

	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_ASSET_LOCATION, () -> {
			return dao().loadPage(null, 25);
		}, modelBuilder::toLocationList);
	}

}
