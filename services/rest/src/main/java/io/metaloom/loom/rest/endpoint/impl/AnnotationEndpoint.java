package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;
import javax.inject.Provider;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.service.impl.AnnotationEndpointService;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class AnnotationEndpoint extends AbstractRESTEndpoint {

	private AnnotationEndpointService annotationService;

	@Inject
	public AnnotationEndpoint(AnnotationEndpointService annotationService, Vertx vertx, Router router, Provider<RestComponent.Builder> restComponentProvider,
		LoomAuthenticationHandler authHandler) {
		super(vertx, router, restComponentProvider, authHandler);
		this.annotationService = annotationService;
	}

	@Override
	public void register() {

	}

}
