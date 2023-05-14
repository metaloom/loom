package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.ReactionEndpointService;

public class ReactionEndpoint extends AbstractCRUDEndpoint<ReactionEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(ReactionEndpoint.class);

	@Inject
	public ReactionEndpoint(ReactionEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "reaction";
	}

	@Override
	protected String basePath() {
		return "/reactions";
	}

}
