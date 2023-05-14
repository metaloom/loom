package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.ProjectEndpointService;

public class ProjectEndpoint extends AbstractCRUDEndpoint<ProjectEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(ProjectEndpoint.class);

	@Inject
	public ProjectEndpoint(ProjectEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "project";
	}

	@Override
	protected String basePath() {
		return "/projects";
	}

}
