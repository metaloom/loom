package io.metaloom.loom.auth.jwt;

import javax.inject.Inject;

import io.metaloom.loom.api.auth.AuthenticationService;

public class JWTAuthenticationServiceImpl implements AuthenticationService {

	@Inject
	public JWTAuthenticationServiceImpl() {
	}

	@Override
	public void verify(String token) {
		System.out.println("Verify of " + token);
	}

}
