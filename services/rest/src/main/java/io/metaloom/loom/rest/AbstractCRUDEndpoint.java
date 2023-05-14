package io.metaloom.loom.rest;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

public abstract class AbstractCRUDEndpoint<S extends AbstractCRUDEndpointService<?, ?>> extends AbstractEndpoint {

	private static final Logger log = LoggerFactory.getLogger(AbstractCRUDEndpoint.class);

	private S service;

	public AbstractCRUDEndpoint(S service, EndpointDependencies deps) {
		super(deps);
		this.service = service;
	}

	protected abstract String basePath();

	@Override
	public void register() {
		log.info("Registering {} endpoint", name());

		secure(basePath() + "*");

		// Create
		addRoute(basePath(), POST, lrc -> {
			service.create(lrc);
		});

		// Update
		addRoute(basePath() + "/:uuid", POST, lrc -> {
			service.update(lrc, lrc.pathParamUUID("uuid"));
		});

		// Delete
		addRoute(basePath() + "/:uuid", DELETE, lrc -> {
			service.delete(lrc, lrc.pathParamUUID("uuid"));
		});

		// List
		addRoute(basePath(), GET, lrc -> {
			service.list(lrc);
		});

		// Read
		addRoute(basePath() + "/:uuid", GET, lrc -> {
			service.load(lrc, lrc.pathParamUUID("uuid"));
		});
	}

}
