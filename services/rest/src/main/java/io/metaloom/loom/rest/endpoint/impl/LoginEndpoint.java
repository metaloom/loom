package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.service.impl.AuthenticationEndpointService;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class LoginEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(LoginEndpoint.class);

	private AuthenticationEndpointService authenticationService;

	@Inject
	public LoginEndpoint(Vertx vertx, @Named("restRouter") Router router,
		Provider<RestComponent.Builder> restComponentProvider, LoomAuthenticationHandler authHandler,
		AuthenticationEndpointService authenticationService) {
		super(vertx, router, restComponentProvider, authHandler);
		this.authenticationService = authenticationService;
	}

	@Override
	public void register() {
		log.info("Registering login endpoints");
		addRoute("/login", POST, lrc -> {
			authenticationService.login(lrc);
		});
	}

}
