package io.metaloom.loom.db.webhook;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.WebhookDao;
import io.metaloom.loom.db.jooq.tables.pojos.Webhook;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqWebhookDaoImpl extends WebhookDao implements LoomWebhookDao {

	@Inject
	public JooqWebhookDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.WEBHOOK;
	// }

	@Override
	public Maybe<? extends LoomWebhook> loadWebhook(UUID uuid) {
		return wrap(findOneById(uuid), JooqWebhookImpl.class);
	}

	@Override
	public void deleteWebhook(LoomWebhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		deleteById(webhook.getUuid());
	}

	@Override
	public Single<? extends LoomWebhook> createWebhook() {
		Webhook webhook = new Webhook();
		return insertReturningPrimary(webhook).map(pk -> new JooqWebhookImpl(webhook.setUuid(pk)));
	}

	@Override
	public Completable updateWebhook(LoomWebhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		Webhook jooqWebhook = unwrap(webhook);
		return update(jooqWebhook).ignoreElement();
	}

	@Override
	public void storeWebhook(LoomWebhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		update(unwrap(webhook));
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
