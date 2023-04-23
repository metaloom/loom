package io.metaloom.loom.auth.jwt;

import javax.inject.Inject;

import io.metaloom.loom.api.auth.AuthenticationService;
import io.metaloom.loom.api.options.LoomOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.jwt.JWTAuth;

public class JWTAuthenticationServiceImpl implements AuthenticationService {

	private final LoomOptions options;
	private final JWTAuth authProvider;

	@Inject
	public JWTAuthenticationServiceImpl(LoomOptions options, JWTAuth authProvider) {
		this.options = options;
		this.authProvider = authProvider;
	}

	@Override
	public void verify(String token) {
		System.out.println("Verify of " + token);
	}

	@Override
	public String generate(JsonObject claims) {
		return authProvider.generateToken(claims, new JWTOptions().setIgnoreExpiration(true));
	}

}
