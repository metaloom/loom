package io.metaloom.loom.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.dagger.RestComponent.Builder;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

@Singleton
public class EndpointDependencies {

	public final Vertx vertx;
	public final Router router;
	public final LoomAuthenticationHandler authHandler;
	public final Provider<Builder> restComponentProvider;

	@Inject
	public EndpointDependencies(Vertx vertx, @Named("restRouter") Router router, Provider<RestComponent.Builder> restComponentProvider,
		LoomAuthenticationHandler authHandler) {
		this.vertx = vertx;
		this.router = router;
		this.authHandler = authHandler;
		this.restComponentProvider = restComponentProvider;
	}
}
