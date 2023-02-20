package io.metaloom.loom.db.model.webhook;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface LoomWebhookDao extends LoomDao {

	default Single<? extends LoomWebhook> createWebhook(String url) {
		return createWebhook(url, null);
	}

	Single<? extends LoomWebhook> createWebhook(String url, Consumer<LoomWebhook> modifier);

	Maybe<? extends LoomWebhook> loadWebhook(UUID uuid);

	Completable updateWebhook(LoomWebhook webhook);

	Completable deleteWebhook(LoomWebhook webhook);

}
