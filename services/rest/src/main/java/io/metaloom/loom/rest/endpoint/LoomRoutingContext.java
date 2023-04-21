package io.metaloom.loom.rest.endpoint;

import io.metaloom.loom.rest.json.Json;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.RestResponseModel;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.auth.User;
import io.vertx.ext.web.RoutingContext;

public class LoomRoutingContext {

	private RoutingContext rc;

	public LoomRoutingContext(RoutingContext rc) {
		this.rc = rc;
	}

	public static LoomRoutingContext wrap(RoutingContext rc) {
		return new LoomRoutingContext(rc);
	}

	public <T extends RestRequestModel> T requestBody(Class<T> clazz) {
		return Json.parse(rc.body().buffer(), clazz);
	}

	public void send(RestResponseModel response) {
		send(response, 200);
	}

	public void send(RestResponseModel response, int statusCode) {
		rc.response().headers().set(HttpHeaders.CONTENT_TYPE, "application/json");
		rc.response().setStatusCode(statusCode).end(Json.encodeToBuffer(response));
	}

	/**
	 * Send a 204 (No Content) response.
	 */
	public void send() {
		rc.response().setStatusCode(204).end();
	}

	public String pathParam(String key) {
		return rc.pathParam(key);
	}

	public User user() {
		return rc.user();
	}

}
