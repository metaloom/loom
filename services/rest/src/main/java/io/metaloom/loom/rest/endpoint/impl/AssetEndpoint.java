package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class AssetEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpoint.class);

	private final AssetDao assetDao;

	private final BinaryDao binaryDao;

	private final LoomModelBuilder modelBuilder;

	@Inject
	public AssetEndpoint(Vertx vertx, @Named("restRouter") Router router, AssetDao assetDao, BinaryDao binaryDao,
		Provider<RestComponent.Builder> restComponentProvider,
		LoomAuthenticationHandler authHandler, LoomModelBuilder modelBuilder) {
		super(vertx, router, restComponentProvider, authHandler);
		this.assetDao = assetDao;
		this.binaryDao = binaryDao;
		this.modelBuilder = modelBuilder;
	}

	@Override
	public void register() {
		log.info("Registering asset endpoint");

		addRoute("/assets", POST, lrc -> {
			AssetCreateRequest request = lrc.requestBody(AssetCreateRequest.class);

			System.out.println("From Request " + request.getLocalPath());
			AssetResponse response = new AssetResponse();
			response.setUuid(UUID.randomUUID());
			lrc.send(response);
		});

		addRoute("/assets/:uuid", DELETE, lrc -> {
			UUID uuid = UUID.fromString(lrc.pathParam("uuid"));
			System.out.println("DELETE ASSET " + uuid);
			// TODO check Perm
			assetDao.delete(uuid);
			AssetResponse response = new AssetResponse();
			response.setUuid(UUID.randomUUID());
			lrc.send();
		});

		addRoute("/assets", GET, lrc -> {
			UUID fromUuid = UUID.fromString(lrc.pathParam("from"));
			int limit = Integer.valueOf(lrc.pathParam("limit"));
			Page<Asset> page = assetDao.loadPage(fromUuid, limit);
			System.out.println("LIST ASSET");
			AssetListResponse response = new AssetListResponse();
			page.forEach(asset -> {
				Binary binary = binaryDao.load(asset.getBinaryUuid());
				AssetResponse assetResponse = modelBuilder.toResponse(asset, binary);
				response.add(assetResponse);
			});
			lrc.send(response);
		});

		addRoute("/assets/:uuid", GET, lrc -> {
			System.out.println("Assets" + lrc.pathParam("uuid"));
			AssetResponse response = new AssetResponse();
			response.setUuid(UUID.randomUUID());
			// throw new RuntimeException("asefgasdgas");
			lrc.send(response);
		});
	}

}
