package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;
import javax.inject.Provider;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.service.impl.TaskEndpointService;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class TaskEndpoint  extends AbstractRESTEndpoint {

	private final TaskEndpointService taskService;

	@Inject
	public TaskEndpoint(TaskEndpointService taskService, Vertx vertx, Router router, Provider<RestComponent.Builder> restComponentProvider,
		LoomAuthenticationHandler authHandler) {
		super(vertx, router, restComponentProvider, authHandler);
		this.taskService = taskService;
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

}
