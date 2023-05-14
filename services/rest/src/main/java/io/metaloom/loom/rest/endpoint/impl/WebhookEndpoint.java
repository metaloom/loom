package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.WebhookEndpointService;

public class WebhookEndpoint extends AbstractCRUDEndpoint<WebhookEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(WebhookEndpoint.class);

	@Inject
	public WebhookEndpoint(WebhookEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "webhook";
	}

	@Override
	protected String basePath() {
		return "/webhooks";
	}

}
