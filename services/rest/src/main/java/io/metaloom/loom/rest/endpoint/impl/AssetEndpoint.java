package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.json.Json;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.RestResponseModel;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class AssetEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpoint.class);

	private LoomAssetDao assetDao;

	@Inject
	public AssetEndpoint(Vertx vertx, @Named("restRouter") Router router, LoomAssetDao assetDao) {
		super(vertx, router);
		this.assetDao = assetDao;
	}

	@Override
	public void register() {
		log.info("Registering asset endpoint");

		router().route("/assets").method(POST).handler(rc -> {
			AssetCreateRequest request = requestBody(rc, AssetCreateRequest.class);

			System.out.println("From Request " + request.getLocalPath());
			AssetResponse response = new AssetResponse();
			response.setUuid(UUID.randomUUID());
			sendResponse(rc, response);
		});

		router().route("/assets/:uuid").method(DELETE).handler(rc -> {
			System.out.println("DELETE ASSET " + rc.pathParam("uuid"));
			AssetResponse response = new AssetResponse();
			response.setUuid(UUID.randomUUID());
			rc.response().end();
		});

		router().route("/assets").method(GET).handler(rc -> {
			System.out.println("LIST ASSET");
			AssetListResponse response = new AssetListResponse();
			AssetResponse asset = new AssetResponse();
			asset.setUuid(UUID.randomUUID());
			response.add(asset);
			sendResponse(rc, response);
		});

		router().route("/assets/:uuid").method(GET).handler(rc -> {
			System.out.println("Assets" + rc.pathParam("uuid"));
			AssetResponse response = new AssetResponse();
			response.setUuid(UUID.randomUUID());
			// throw new RuntimeException("asefgasdgas");
			sendResponse(rc, response);
		});
	}


}
