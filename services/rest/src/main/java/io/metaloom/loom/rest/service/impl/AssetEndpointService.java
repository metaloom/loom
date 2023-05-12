package io.metaloom.loom.rest.service.impl;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.location.LocationResponse;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class AssetEndpointService extends AbstractEndpointService {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpointService.class);

	private AssetDao assetDao;

	@Inject
	public AssetEndpointService(AssetDao assetDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.assetDao = assetDao;
	}

	public void delete(LoomRoutingContext lrc) {
		UUID uuid = UUID.fromString(lrc.pathParam("uuid"));
		System.out.println("DELETE ASSET " + uuid);
		// TODO check Perm
		assetDao.delete(uuid);
		LocationResponse response = new LocationResponse();
		response.setUuid(UUID.randomUUID());
		lrc.send();

	}

	public void list(LoomRoutingContext lrc) {
		String fromStr = lrc.pathParam("from");
		UUID fromUuid = null;
		if (fromStr != null) {
			fromUuid = UUID.fromString(fromStr);
		}
		String limitStr = lrc.pathParam("limit");
		int limit = 25;
		if (limitStr != null) {
			limit = Integer.valueOf(limitStr);
		}
		Page<Asset> page = assetDao.loadPage(fromUuid, limit);
		AssetListResponse response = modelBuilder.toAssetList(page);
		lrc.send(response);
	}

	public void load(LoomRoutingContext lrc) {
		UUID uuid = UUID.fromString(lrc.pathParam("uuid"));
		Asset asset = assetDao.load(uuid);
		AssetResponse response = modelBuilder.toResponse(asset);
		lrc.send(response);
	}

	public void create(LoomRoutingContext lrc) {
		AssetCreateRequest request = lrc.requestBody(AssetCreateRequest.class);

		System.out.println("From Request " + request.getLocalPath());
		LocationResponse response = new LocationResponse();
		response.setUuid(UUID.randomUUID());
		lrc.send(response);
	}

}
