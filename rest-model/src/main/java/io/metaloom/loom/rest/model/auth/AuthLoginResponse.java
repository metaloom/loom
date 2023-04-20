package io.metaloom.loom.rest.model.auth;

import io.metaloom.loom.rest.model.RestResponseModel;

public class AuthLoginResponse implements RestResponseModel {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
