package io.metaloom.loom.db.webhook;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.WebhookDao;
import io.reactivex.Maybe;

public class JooqWebhooksDaoImpl extends AbstractJooqDao implements WebhooksDao {

	private final WebhookDao delegate;

	protected JooqType getType() {
		return JooqType.WEBHOOK;
	}

	public JooqWebhooksDaoImpl(WebhookDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Webhook> loadWebhook(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqWebhookImpl.class);
	}

	@Override
	public void deleteWebhook(Webhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		delegate.deleteById(webhook.getUuid());
	}

	@Override
	public Webhook createWebhook() {
		io.metaloom.loom.db.jooq.tables.pojos.Webhook webhook = new io.metaloom.loom.db.jooq.tables.pojos.Webhook();
		delegate.insert(webhook);
		return new JooqWebhookImpl(webhook);
	}

	@Override
	public void updateWebhook(Webhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Webhook jooqWebhook = unwrap(webhook);
		delegate.update(jooqWebhook);
	}

	@Override
	public void storeWebhook(Webhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		delegate.update(unwrap(webhook));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
