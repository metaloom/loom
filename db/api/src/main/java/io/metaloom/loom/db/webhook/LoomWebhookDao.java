package io.metaloom.loom.db.webhook;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface LoomWebhookDao extends LoomDao {

	Single<? extends LoomWebhook> createWebhook();

	Maybe<? extends LoomWebhook> loadWebhook(UUID uuid);

	Completable updateWebhook(LoomWebhook webhook);

	void deleteWebhook(LoomWebhook webhook);

	void storeWebhook(LoomWebhook webhook);

}
