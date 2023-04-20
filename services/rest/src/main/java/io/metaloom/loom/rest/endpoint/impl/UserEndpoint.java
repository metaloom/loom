package io.metaloom.loom.rest.endpoint.impl;

import io.metaloom.loom.auth.LoomAuthHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.model.user.UserResponse;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

import static io.vertx.core.http.HttpMethod.GET;

public class UserEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);
	private final LoomAuthHandler authHandler;

	@Inject
	public UserEndpoint(Vertx vertx, @Named("restRouter") Router router, LoomAuthHandler authHandler) {
		super(vertx, router);
		this.authHandler = authHandler;
	}

	@Override
	public void register() {
		log.info("Registering users endpoint");
		router().route("/users").handler(authHandler);
		router().route("/users").method(GET).handler(rc -> {
			System.out.println("Get Users: " + rc.user());
			UserResponse response = new UserResponse();
			response.setUsername("Test1234");
			sendResponse(rc, response);
		});
	}

}
