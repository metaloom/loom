package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.auth.AuthLoginRequest;

public class MixedExamples extends AbstractExamples {

	public static AuthLoginRequest loginRequest() {
		AuthLoginRequest model = new AuthLoginRequest();
		model.setUsername("joedoe");
		model.setPassword("wae8aoK3cohthaum0Shi");
		return model;
	}
}
