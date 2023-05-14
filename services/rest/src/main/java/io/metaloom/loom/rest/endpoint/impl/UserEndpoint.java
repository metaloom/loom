package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dagger.multibindings.ElementsIntoSet;
import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.dagger.RESTEndpoints;
import io.metaloom.loom.rest.service.impl.UserEndpointService;

public class UserEndpoint extends AbstractCRUDEndpoint<UserEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);

	@Inject
	public UserEndpoint(UserEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "user";
	}

	@Override
	protected String basePath() {
		return "/users";
	}
}
