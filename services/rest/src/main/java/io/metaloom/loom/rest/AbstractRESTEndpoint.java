package io.metaloom.loom.rest;

import javax.inject.Provider;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.dagger.RestComponent.Builder;
import io.metaloom.loom.rest.endpoint.RESTEndpoint;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public abstract class AbstractRESTEndpoint implements RESTEndpoint {

	private final Vertx vertx;
	private final Router router;
	private final LoomAuthenticationHandler authHandler;
	private final Provider<Builder> restComponentProvider;

	public AbstractRESTEndpoint(Vertx vertx, Router router, Provider<RestComponent.Builder> restComponentProvider,
		LoomAuthenticationHandler authHandler) {
		this.vertx = vertx;
		this.router = router;
		this.authHandler = authHandler;
		this.restComponentProvider = restComponentProvider;
	}

	public Router router() {
		return router;
	}

	public Vertx vertx() {
		return vertx;
	}

	public <REQ extends RestRequestModel> void addRoute(String path, HttpMethod method, Handler<LoomRoutingContext> handler) {
		router().route(path).method(method).handler(rc -> {
			// Construct a new subtree so we can use DI in the scope of a request
			RestComponent requestComponent = restComponentProvider.get()
				.context(rc)
				.build();
			LoomRoutingContext loomContext = requestComponent.requestHandler();
			handler.handle(loomContext);
		});
	}

	public void secure(String path) {
		router().route(path).handler(authHandler);
	}

}
