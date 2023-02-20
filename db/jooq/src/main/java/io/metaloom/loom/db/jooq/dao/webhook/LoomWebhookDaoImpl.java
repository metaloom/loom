package io.metaloom.loom.db.jooq.dao.webhook;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.pojos.Webhook;
import io.metaloom.loom.db.model.webhook.LoomWebhook;
import io.metaloom.loom.db.model.webhook.LoomWebhookDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class LoomWebhookDaoImpl extends AbstractDao implements LoomWebhookDao {

	@Inject
	public LoomWebhookDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	// @Override
	// public Maybe<? extends LoomWebhook> loadWebhook(UUID uuid) {
	// return wrap(findOneById(uuid), LoomWebhookImpl.class);
	// }
	//
	// @Override
	// public Completable deleteWebhook(LoomWebhook webhook) {
	// Objects.requireNonNull(webhook, "Webhook must not be null");
	// return deleteById(webhook.getUuid()).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomWebhook> createWebhook() {
	// Webhook webhook = new Webhook();
	// return insertReturningPrimary(webhook).map(pk -> new LoomWebhookImpl(webhook.setUuid(pk)));
	// }
	//
	// @Override
	// public Completable updateWebhook(LoomWebhook webhook) {
	// Objects.requireNonNull(webhook, "Webhook must not be null");
	// Webhook jooqWebhook = unwrap(webhook);
	// return update(jooqWebhook).ignoreElement();
	// }

	@Override
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public Single<? extends LoomWebhook> createWebhook(String url, Consumer<LoomWebhook> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends LoomWebhook> loadWebhook(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateWebhook(LoomWebhook webhook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteWebhook(LoomWebhook webhook) {
		// TODO Auto-generated method stub
		return null;
	}

}
