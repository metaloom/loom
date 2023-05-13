package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.service.impl.AssetEndpointService;
import io.metaloom.utils.hash.SHA512Sum;

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

		addRoute(basePath(), POST, lrc -> {
			service.create(lrc);
		});

		addRoute(basePath() + "/:sha512", POST, lrc -> {
			service.update(lrc, pathHash(lrc, "sha512"));
		});

		addRoute(basePath() + "/:sha512", DELETE, lrc -> {
			service.delete(lrc, pathHash(lrc, "sha512"));
		});

		addRoute(basePath(), GET, lrc -> {
			service.list(lrc);
		});

		addRoute(basePath() + "/:sha512", GET, lrc -> {
			service.load(lrc, pathHash(lrc, "sha512"));
		});
	}

	private String basePath() {
		return "/assets";
	}
	
	public SHA512Sum pathHash(LoomRoutingContext lrc, String key) {
		String value = lrc.pathParam(key);
		return SHA512Sum.fromString(value);
	}
}
