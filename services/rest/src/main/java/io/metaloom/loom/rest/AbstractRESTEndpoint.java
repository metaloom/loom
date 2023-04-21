package io.metaloom.loom.rest;

import io.metaloom.loom.auth.LoomAuthHandler;
import io.metaloom.loom.rest.endpoint.LoomRoutingContext;
import io.metaloom.loom.rest.endpoint.RESTEndpoint;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public abstract class AbstractRESTEndpoint implements RESTEndpoint {

	private final Vertx vertx;
	private final Router router;
	private final LoomAuthHandler authHandler;

	public AbstractRESTEndpoint(Vertx vertx, Router router, LoomAuthHandler authHandler) {
		this.vertx = vertx;
		this.router = router;
		this.authHandler = authHandler;
	}

	public Router router() {
		return router;
	}

	public Vertx vertx() {
		return vertx;
	}

	public <REQ extends RestRequestModel> void addRoute(String path, HttpMethod method, Handler<LoomRoutingContext> handler) {
		router().route(path).method(method).handler(rc -> {
			handler.handle(LoomRoutingContext.wrap(rc));
		});
	}

	public void secure(String path) {
		router().route(path).handler(authHandler);
	}

}
