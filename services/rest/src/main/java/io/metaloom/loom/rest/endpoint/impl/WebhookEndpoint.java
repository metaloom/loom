package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;
import javax.inject.Provider;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.service.impl.WebhookEndpointService;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class WebhookEndpoint extends AbstractRESTEndpoint {

	private WebhookEndpointService webhookService;

	@Inject
	public WebhookEndpoint(WebhookEndpointService webhookService, Vertx vertx, Router router, Provider<RestComponent.Builder> restComponentProvider,
		LoomAuthenticationHandler authHandler) {
		super(vertx, router, restComponentProvider, authHandler);
		this.webhookService = webhookService;
	}

	@Override
	public void register() {

	}

}
