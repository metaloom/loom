package io.metaloom.loom.api.auth;

import io.vertx.core.json.JsonObject;

public interface AuthenticationService {

	void verify(String token);

	String generate(JsonObject json);

	void init() throws Exception;

}
