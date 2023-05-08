package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.webhook.WebhookDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class WebhookEndpointService extends AbstractEndpointService {

	private final WebhookDao webhookDao;

	@Inject
	public WebhookEndpointService(WebhookDao webhookDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.webhookDao = webhookDao;
	}

}
