package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.GroupEndpointService;

public class GroupEndpoint extends AbstractRESTEndpoint {

	private final GroupEndpointService groupService;

	@Inject
	public GroupEndpoint(GroupEndpointService groupService, EndpointDependencies deps) {
		super(deps);
		this.groupService = groupService;
	}

	@Override
	public void register() {

	}

}
