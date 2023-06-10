package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AttachmentEndpointService;

public class AttachmentEndpoint extends AbstractCRUDEndpoint<AttachmentEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(AttachmentEndpoint.class);

	@Inject
	public AttachmentEndpoint(AttachmentEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "attachment";
	}

	@Override
	protected String basePath() {
		return "/attachments";
	}

	@Override
	public void register() {
		log.info("Registering {} endpoint", name());

		secure(basePath() + "*");

		// Create
		addRoute(basePath(), POST, "Create a new attachment", lrc -> {
			service().create(lrc);
		});

		// Update
		addRoute(basePath() + "/:uuid", POST, "Update a existing attachment", lrc -> {
			service().update(lrc, lrc.pathParamUUID("uuid"));
		});

		// Delete
		addRoute(basePath() + "/:uuid", DELETE, "Delete a specific attachment", lrc -> {
			service().delete(lrc, lrc.pathParamUUID("uuid"));
		});

		// List
		addRoute(basePath(), GET, "Load a paged list of attachments", lrc -> {
			service().list(lrc);
		});

		// Read
		addRoute(basePath() + "/:uuid", GET, "Load a specific attachment", lrc -> {
			service().load(lrc, lrc.pathParamUUID("uuid"));
		});

	}

}
