package io.metaloom.loom.rest.model.auth;

import io.metaloom.loom.rest.model.RestModel;

public class AuthLoginRequest implements RestModel {

	private String username;

	private String password;

	public AuthLoginRequest() {
	}

	public String getUsername() {
		return username;
	}

	public AuthLoginRequest setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public AuthLoginRequest setPassword(String password) {
		this.password = password;
		return this;
	}
}
