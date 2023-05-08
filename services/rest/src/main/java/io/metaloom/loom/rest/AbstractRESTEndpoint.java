package io.metaloom.loom.rest;

import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.endpoint.RESTEndpoint;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public abstract class AbstractRESTEndpoint implements RESTEndpoint {

	private EndpointDependencies deps;

	public AbstractRESTEndpoint(EndpointDependencies deps) {
		this.deps = deps;
	}

	public Router router() {
		return deps.router;
	}

	public Vertx vertx() {
		return deps.vertx;
	}

	public <REQ extends RestRequestModel> void addRoute(String path, HttpMethod method, Handler<LoomRoutingContext> handler) {
		router().route(path).method(method).handler(rc -> {
			// Construct a new subtree so we can use DI in the scope of a request
			RestComponent requestComponent = deps.restComponentProvider.get()
				.context(rc)
				.build();
			LoomRoutingContext loomContext = requestComponent.requestHandler();
			handler.handle(loomContext);
		});
	}

	public void secure(String path) {
		router().route(path).handler(deps.authHandler);
	}

}
