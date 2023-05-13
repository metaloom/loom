package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.GroupEndpointService;

public class GroupEndpoint extends AbstractCRUDEndpoint<GroupEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(GroupEndpoint.class);

	@Inject
	public GroupEndpoint(GroupEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	protected String name() {
		return "group";
	}

	@Override
	protected String basePath() {
		return "/groups";
	}

}
