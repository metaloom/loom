package io.metaloom.loom.rest.endpoint.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.CollectionEndpointService;
import io.metaloom.loom.rest.service.impl.EmbeddingEndpointService;

public class EmbeddingEndpoint extends AbstractCRUDEndpoint<EmbeddingEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(CollectionEndpointService.class);

	public EmbeddingEndpoint(EmbeddingEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	protected String name() {
		return "embedding";
	}

	@Override
	protected String basePath() {
		return "/embeddings";
	}

}
