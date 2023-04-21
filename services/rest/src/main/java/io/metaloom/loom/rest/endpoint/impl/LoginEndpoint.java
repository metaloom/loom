package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.auth.AuthenticationService;
import io.metaloom.loom.auth.LoomAuthHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.model.auth.AuthLoginRequest;
import io.metaloom.loom.rest.model.auth.AuthLoginResponse;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class LoginEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(LoginEndpoint.class);

	private final AuthenticationService authService;

	@Inject
	public LoginEndpoint(Vertx vertx, @Named("restRouter") Router router, AuthenticationService authService, LoomAuthHandler authHandler) {
		super(vertx, router, authHandler);
		this.authService = authService;
	}

	@Override
	public void register() {
		log.info("Registering login endpoints");
		addRoute("/login", POST, lrc -> {
			AuthLoginRequest request = lrc.requestBody(AuthLoginRequest.class);
			String token = authService.generate(new JsonObject().put("sub", request.getUsername()));
			AuthLoginResponse response = new AuthLoginResponse();
			response.setToken(token);
			lrc.send(response);
		});
	}

}
