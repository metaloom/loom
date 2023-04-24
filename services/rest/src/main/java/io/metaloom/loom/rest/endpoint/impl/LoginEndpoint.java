package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.auth.AuthenticationService;
import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.model.auth.AuthLoginRequest;
import io.metaloom.loom.rest.model.auth.AuthLoginResponse;
import io.metaloom.loom.rest.model.message.GenericMessageResponse;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class LoginEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(LoginEndpoint.class);

	private final AuthenticationService authService;

	@Inject
	public LoginEndpoint(Vertx vertx, @Named("restRouter") Router router, AuthenticationService authService,
		Provider<RestComponent.Builder> restComponentProvider, LoomAuthenticationHandler authHandler) {
		super(vertx, router, restComponentProvider, authHandler);
		this.authService = authService;
	}

	@Override
	public void register() {
		log.info("Registering login endpoints");
		addRoute("/login", POST, lrc -> {
			AuthLoginRequest request = lrc.requestBody(AuthLoginRequest.class);
			User user = authService.login(request.getUsername(), request.getPassword());
			if (user == null) {
				lrc.send(new GenericMessageResponse().setMessage("Login failed"), 401);
			} else {
				String token = authService.generate(new JsonObject().put("uuid", user.getUuid().toString()));
				AuthLoginResponse response = new AuthLoginResponse();
				response.setToken(token);
				lrc.send(response);
			}
		});
	}

}
