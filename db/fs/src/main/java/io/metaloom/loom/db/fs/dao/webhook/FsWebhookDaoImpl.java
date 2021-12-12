package io.metaloom.loom.db.fs.dao.webhook;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.webhook.Webhook;
import io.metaloom.loom.db.model.webhook.WebhookDao;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsWebhookDaoImpl extends AbstractFSDao implements WebhookDao {

	@Inject
	public FsWebhookDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.WEBHOOK;
	}

	@Override
	public Maybe<? extends Webhook> loadWebhook(UUID uuid) {
		return load(uuid, FsWebhookImpl.class);
	}

	@Override
	public Completable deleteWebhook(Webhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		return delete(webhook.getUuid());
	}

	@Override
	public Single<? extends Webhook> createWebhook(String url, Consumer<Webhook> modifier) {
		return Single.fromCallable(() -> {
			Webhook webhook = new FsWebhookImpl(url);
			webhook.setUuid(UUIDUtil.randomUUID());
			if (modifier != null) {
				modifier.accept(webhook);
			}
			return webhook;
		});
	}

	@Override
	public Completable updateWebhook(Webhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		return store(webhook).ignoreElement();
	}

}
