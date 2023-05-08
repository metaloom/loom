package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.ProjectEndpointService;

public class ProjectEndpoint extends AbstractRESTEndpoint {

	private final ProjectEndpointService projectService;

	@Inject
	public ProjectEndpoint(ProjectEndpointService projectService, EndpointDependencies deps) {
		super(deps);
		this.projectService = projectService;
	}

	@Override
	public void register() {

	}

}
