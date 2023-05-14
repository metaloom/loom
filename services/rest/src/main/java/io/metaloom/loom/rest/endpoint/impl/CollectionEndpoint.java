package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.CollectionEndpointService;

public class CollectionEndpoint extends AbstractCRUDEndpoint<CollectionEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(CollectionEndpoint.class);

	@Inject
	public CollectionEndpoint(CollectionEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "collection";
	}

	@Override
	protected String basePath() {
		return "/collections";
	}

}
