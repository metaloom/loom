package io.metaloom.loom.db.webhook;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsWebhookDaoImpl extends AbstractFSDao implements LoomWebhookDao {

	@Inject
	public FsWebhookDaoImpl(DaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.WEBHOOK;
	}

	@Override
	public Maybe<? extends LoomWebhook> loadWebhook(UUID uuid) {
		return load(uuid, FsWebhookImpl.class);
	}

	@Override
	public Completable deleteWebhook(LoomWebhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		return delete(webhook.getUuid());
	}

	@Override
	public Single<? extends LoomWebhook> createWebhook() {
		return Single.fromCallable(() -> {
			LoomWebhook webhook = new FsWebhookImpl();
			webhook.setUuid(UUIDUtil.randomUUID());
			return webhook;
		});
	}

	@Override
	public Completable updateWebhook(LoomWebhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		return store(webhook).ignoreElement();
	}

}
