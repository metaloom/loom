package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.service.impl.UserEndpointService;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class UserEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);
	private final UserEndpointService userService;

	@Inject
	public UserEndpoint(Vertx vertx, @Named("restRouter") Router router, LoomAuthenticationHandler authHandler,
		Provider<RestComponent.Builder> restComponentProvider, UserEndpointService userService) {
		super(vertx, router, restComponentProvider, authHandler);
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
