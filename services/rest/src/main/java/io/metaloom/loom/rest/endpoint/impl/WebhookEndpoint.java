package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.WebhookEndpointService;

public class WebhookEndpoint extends AbstractRESTEndpoint {

	private WebhookEndpointService webhookService;

	@Inject
	public WebhookEndpoint(WebhookEndpointService webhookService, EndpointDependencies deps) {
		super(deps);
		this.webhookService = webhookService;
	}

	@Override
	public void register() {

	}

}
