package io.metaloom.loom.db.model.webhook;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface WebhookDao extends LoomDao {

	Single<? extends Webhook> createWebhook();

	Maybe<? extends Webhook> loadWebhook(UUID uuid);

	Completable updateWebhook(Webhook webhook);

	Completable deleteWebhook(Webhook webhook);

}
