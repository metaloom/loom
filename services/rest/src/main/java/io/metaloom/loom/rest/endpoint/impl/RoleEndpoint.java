package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.RoleEndpointService;

public class RoleEndpoint extends AbstractCRUDEndpoint<RoleEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(RoleEndpoint.class);

	@Inject
	public RoleEndpoint(RoleEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	protected String name() {
		return "role";
	}

	@Override
	protected String basePath() {
		return "/roles";
	}
}
