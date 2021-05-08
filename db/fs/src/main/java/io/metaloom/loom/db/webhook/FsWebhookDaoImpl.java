package io.metaloom.loom.db.webhook;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class FsWebhookDaoImpl extends AbstractFSDao implements LoomWebhookDao {

	@Inject
	public FsWebhookDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.WEBHOOK;
	}

	@Override
	public Maybe<? extends LoomWebhook> loadWebhook(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsWebhookImpl.class);
	}

	@Override
	public void deleteWebhook(LoomWebhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		FilesystemIoHelper.delete(getType(), webhook.getUuid());
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
		return Completable.fromAction(() -> {
			FilesystemIoHelper.store(getType(), webhook.getUuid(), webhook);
		});
	}

	@Override
	public void storeWebhook(LoomWebhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		FilesystemIoHelper.store(getType(), webhook.getUuid(), webhook);
	}


}
