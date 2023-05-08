package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.TaskEndpointService;

public class TaskEndpoint  extends AbstractRESTEndpoint {

	private final TaskEndpointService taskService;

	@Inject
	public TaskEndpoint(TaskEndpointService taskService, EndpointDependencies deps) {
		super(deps);
		this.taskService = taskService;
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

}
