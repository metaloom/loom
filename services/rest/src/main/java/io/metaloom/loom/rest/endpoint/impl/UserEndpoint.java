package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.UserEndpointService;

public class UserEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);
	private final UserEndpointService userService;

	@Inject
	public UserEndpoint(EndpointDependencies deps, UserEndpointService userService) {
		super(deps);
		this.userService = userService;
	}

	@Override
	public void register() {
		log.info("Registering users endpoint");

		secure("/users*");

		addRoute("/users/:uuid", DELETE, lrc -> {
			userService.delete(lrc);
		});

		addRoute("/users", GET, lrc -> {
			userService.listUsers(lrc);
		});

		addRoute("/users", POST, lrc -> {
			userService.createUser(lrc);
		});

		addRoute("/users/:name", GET, lrc -> {
			userService.loadUser(lrc);
		});
	}
}
