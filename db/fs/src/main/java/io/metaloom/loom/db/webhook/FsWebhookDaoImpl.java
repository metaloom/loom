package io.metaloom.loom.db.webhook;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;

@Singleton
public class FsWebhookDaoImpl extends AbstractFSDao implements WebhookDao {

	@Inject
	public FsWebhookDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.WEBHOOK;
	}

	@Override
	public Maybe<? extends Webhook> loadWebhook(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsWebhookImpl.class);
	}

	@Override
	public void deleteWebhook(Webhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		FilesystemIoHelper.delete(getType(), webhook.getUuid());
	}

	@Override
	public Webhook createWebhook() {
		Webhook webhook = new FsWebhookImpl();
		webhook.setUuid(UUIDUtil.randomUUID());
		return webhook;
	}

	@Override
	public void updateWebhook(Webhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		FilesystemIoHelper.store(getType(), webhook.getUuid(), webhook);
	}

	@Override
	public void storeWebhook(Webhook webhook) {
		Objects.requireNonNull(webhook, "Webhook must not be null");
		FilesystemIoHelper.store(getType(), webhook.getUuid(), webhook);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
