package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;
import javax.inject.Provider;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.service.impl.GroupEndpointService;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class GroupEndpoint extends AbstractRESTEndpoint {

	private GroupEndpointService groupService;

	@Inject
	public GroupEndpoint(GroupEndpointService groupService, Vertx vertx, Router router, Provider<RestComponent.Builder> restComponentProvider,
		LoomAuthenticationHandler authHandler) {
		super(vertx, router, restComponentProvider, authHandler);
		this.groupService = groupService;
	}

	@Override
	public void register() {

	}

}
