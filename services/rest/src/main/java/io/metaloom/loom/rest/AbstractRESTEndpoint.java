package io.metaloom.loom.rest;

import io.metaloom.loom.rest.endpoint.RESTEndpoint;
import io.metaloom.loom.rest.json.Json;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.RestResponseModel;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public abstract class AbstractRESTEndpoint implements RESTEndpoint {

	private final Router router;
	private final Vertx vertx;

	public AbstractRESTEndpoint(Vertx vertx, Router router) {
		this.vertx = vertx;
		this.router = router;
	}

	public Router router() {
		return router;
	}

	public Vertx vertx() {
		return vertx;
	}


	protected void sendResponse(RoutingContext rc, RestResponseModel model) {
		rc.response().headers().set(HttpHeaders.CONTENT_TYPE, "application/json");
		rc.response().end(Json.encodeToBuffer(model));
	}

	protected <T extends RestRequestModel> T requestBody(RoutingContext rc, Class<T> clazz) {
		return Json.parse(rc.body().buffer(), clazz);
	}

}
