package io.metaloom.loom.rest.service.impl;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.binary.BinaryDao;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class AssetEndpointService extends AbstractEndpointService {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpointService.class);

	private BinaryDao binaryDao;
	private AssetDao assetDao;

	@Inject
	public AssetEndpointService(AssetDao assetDao, BinaryDao binaryDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.assetDao = assetDao;
		this.binaryDao = binaryDao;
	}

	public void delete(LoomRoutingContext lrc) {
		UUID uuid = UUID.fromString(lrc.pathParam("uuid"));
		System.out.println("DELETE ASSET " + uuid);
		// TODO check Perm
		assetDao.delete(uuid);
		AssetResponse response = new AssetResponse();
		response.setUuid(UUID.randomUUID());
		lrc.send();

	}

	public void list(LoomRoutingContext lrc) {
		UUID fromUuid = UUID.fromString(lrc.pathParam("from"));
		int limit = Integer.valueOf(lrc.pathParam("limit"));
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
		AssetResponse response = new AssetResponse();
		response.setUuid(UUID.randomUUID());
		lrc.send(response);
	}

}
