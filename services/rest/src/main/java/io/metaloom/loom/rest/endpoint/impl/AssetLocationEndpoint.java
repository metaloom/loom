package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AssetLocationEndpointService;

public class AssetLocationEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(AssetLocationEndpoint.class);

	private final AssetLocationEndpointService service;

	@Inject
	public AssetLocationEndpoint(AssetLocationEndpointService assetLocationService, EndpointDependencies deps) {
		super(deps);
		this.service = assetLocationService;
	}

	@Override
	public void register() {
		log.info("Registering asset location endpoint");

		addRoute("/assets/:assetUuid/locations", POST, lrc -> {
			service.create(lrc);
		});

		addRoute("/assets/:assetUuid/locations/:uuid", DELETE, lrc -> {
			service.delete(lrc);
		});

		addRoute("/assets/:assetUuid/locations", GET, lrc -> {
			service.list(lrc);
		});

		addRoute("/assets/:assetUuid/locations/:uuid", GET, lrc -> {
			service.load(lrc);
		});
	}

}
