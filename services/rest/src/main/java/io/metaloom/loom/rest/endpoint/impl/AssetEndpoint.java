package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.auth.LoomAuthHandler;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class AssetEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpoint.class);

	private LoomAssetDao assetDao;

	@Inject
	public AssetEndpoint(Vertx vertx, @Named("restRouter") Router router, LoomAssetDao assetDao, LoomAuthHandler authHandler) {
		super(vertx, router, authHandler);
		this.assetDao = assetDao;
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
			System.out.println("DELETE ASSET " + lrc.pathParam("uuid"));
			AssetResponse response = new AssetResponse();
			response.setUuid(UUID.randomUUID());
			lrc.send();
		});

		addRoute("/assets", GET, lrc -> {
			System.out.println("LIST ASSET");
			AssetListResponse response = new AssetListResponse();
			AssetResponse asset = new AssetResponse();
			asset.setUuid(UUID.randomUUID());
			response.add(asset);
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
