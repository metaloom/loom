package io.metaloom.loom.db.webhook;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface WebhookDao extends LoomDao {

	Single<? extends Webhook> createWebhook();

	Maybe<? extends Webhook> loadWebhook(UUID uuid);

	Completable updateWebhook(Webhook webhook);

	void deleteWebhook(Webhook webhook);

	void storeWebhook(Webhook webhook);

}
