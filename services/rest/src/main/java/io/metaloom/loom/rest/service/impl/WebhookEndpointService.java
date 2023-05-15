package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_WEBHOOK;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_WEBHOOK;
import static io.metaloom.loom.db.model.perm.Permission.READ_WEBHOOK;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_WEBHOOK;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.webhook.Webhook;
import io.metaloom.loom.db.model.webhook.WebhookDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;

@Singleton
public class WebhookEndpointService extends AbstractCRUDEndpointService<WebhookDao, Webhook> {

	@Inject
	public WebhookEndpointService(WebhookDao webhookDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(webhookDao, daos, modelBuilder, validator);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_WEBHOOK, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_WEBHOOK, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toWebhookList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_WEBHOOK, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_WEBHOOK, () -> {
			UUID userUuid = lrc.userUuid();
			String url = null;
			return dao().createWebhook(userUuid, url);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_WEBHOOK, () -> {
			Webhook webhook = dao().load(id);
			// TOOD update
			return dao().update(webhook);
		}, modelBuilder::toResponse);
	}
}
