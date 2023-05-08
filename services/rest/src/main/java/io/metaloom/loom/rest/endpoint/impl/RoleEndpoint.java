package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;
import javax.inject.Provider;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.service.impl.RoleEndpointService;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class RoleEndpoint extends AbstractRESTEndpoint {

	private final RoleEndpointService roleService;

	@Inject
	public RoleEndpoint(RoleEndpointService roleService, EndpointDependencies deps) {
		super(deps);
		this.roleService = roleService;
	}

	@Override
	public void register() {

	}

}