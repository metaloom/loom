package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AssetEndpointService;

public class AssetEndpoint extends AbstractEndpoint {

	private static final Logger log = LoggerFactory.getLogger(AssetEndpoint.class);
	private final AssetEndpointService service;

	@Inject
	public AssetEndpoint(AssetEndpointService service, EndpointDependencies deps) {
		super(deps);
		this.service = service;
	}

	@Override
	public void register() {
		log.info("Registering assets endpoint");

		secure(basePath() + "*");
		addRoute(basePath(), POST, lrc -> {
			service.create(lrc);
		});

		addRoute(basePath() + "/:sha512orUUID", POST, lrc -> {
			service.update(lrc, lrc.pathParam("sha512orUUID"));
		});

		addRoute(basePath() + "/:sha512orUUID", DELETE, lrc -> {
			service.delete(lrc, lrc.pathParam("sha512orUUID"));
		});

		addRoute(basePath(), GET, lrc -> {
			service.list(lrc);
		});

		addRoute(basePath() + "/:sha512orUUID", GET, lrc -> {
			service.load(lrc, lrc.pathParam("sha512orUUID"));
		});
	}

	private String basePath() {
		return "/assets";
	}

}
