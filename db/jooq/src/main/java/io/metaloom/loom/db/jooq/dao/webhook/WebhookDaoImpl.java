package io.metaloom.loom.db.jooq.dao.webhook;

import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqWebhookDao;
import io.metaloom.loom.db.model.webhook.Webhook;
import io.metaloom.loom.db.model.webhook.WebhookDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class WebhookDaoImpl extends AbstractJooqDao<JooqWebhookDao> implements WebhookDao {

	@Inject
	public WebhookDaoImpl(JooqWebhookDao dao, DSLContext ctx) {
		super(dao, ctx);
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
	public Single<? extends Webhook> createWebhook(String url, Consumer<Webhook> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Webhook> loadWebhook(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateWebhook(Webhook webhook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteWebhook(Webhook webhook) {
		// TODO Auto-generated method stub
		return null;
	}

}
