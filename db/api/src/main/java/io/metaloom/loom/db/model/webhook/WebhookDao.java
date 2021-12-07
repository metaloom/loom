package io.metaloom.loom.db.model.webhook;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface WebhookDao extends LoomDao {

	default Single<? extends Webhook> createWebhook(String url) {
		return createWebhook(url, null);
	}

	Single<? extends Webhook> createWebhook(String url, Consumer<Webhook> modifier);

	Maybe<? extends Webhook> loadWebhook(UUID uuid);

	Completable updateWebhook(Webhook webhook);

	Completable deleteWebhook(Webhook webhook);

}
