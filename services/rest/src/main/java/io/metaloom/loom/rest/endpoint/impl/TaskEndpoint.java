package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.TaskEndpointService;

public class TaskEndpoint extends AbstractCRUDEndpoint<TaskEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(TaskEndpoint.class);

	@Inject
	public TaskEndpoint(TaskEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	protected String name() {
		return "task";
	}

	@Override
	protected String basePath() {
		return "/tasks";
	}
}
