package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.CollectionEndpointService;
import io.metaloom.loom.rest.service.impl.EmbeddingEndpointService;

public class EmbeddingEndpoint extends AbstractCRUDEndpoint<EmbeddingEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(CollectionEndpointService.class);

	@Inject
	public EmbeddingEndpoint(EmbeddingEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "embedding";
	}

	@Override
	protected String basePath() {
		return "/embeddings";
	}

	@Override
	public void register() {
		super.register();

		addRoute(basePath() + "/:embeddingUuid/attachments", POST, "Create a new attachment for the embedding", lrc -> {
			service().createEmbeddingAttachment(lrc.pathParamUUID("embeddingUuid"));
		});
		addRoute(basePath() + "/:embeddingUuid/attachments", GET, "List the attachments for the embedding", lrc -> {
			service().listEmbeddingAttachments(lrc.pathParamUUID("embeddingUuid"));
		});

	}

}
