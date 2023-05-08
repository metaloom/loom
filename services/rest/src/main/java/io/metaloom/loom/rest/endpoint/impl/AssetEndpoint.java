package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AssetEndpointService;

public class AssetEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpoint.class);

	private final AssetEndpointService assetService;

	@Inject
	public AssetEndpoint(EndpointDependencies deps, AssetEndpointService assetService) {
		super(deps);
		this.assetService = assetService;
	}

	@Override
	public void register() {
		log.info("Registering asset endpoint");

		addRoute("/assets", POST, lrc -> {
			assetService.create(lrc);
		});

		addRoute("/assets/:uuid", DELETE, lrc -> {
			assetService.delete(lrc);
		});

		addRoute("/assets", GET, lrc -> {
			assetService.list(lrc);
		});

		addRoute("/assets/:uuid", GET, lrc -> {
			assetService.load(lrc);
		});
	}

}
