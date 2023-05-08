package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AuthenticationEndpointService;

public class LoginEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(LoginEndpoint.class);

	private final AuthenticationEndpointService authenticationService;

	@Inject
	public LoginEndpoint(EndpointDependencies deps, AuthenticationEndpointService authenticationService) {
		super(deps);
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
