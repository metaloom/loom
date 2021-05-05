package io.metaloom.loom.db.webhook;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface WebhooksDao extends LoomDao {

	Webhook createWebhook();

	Maybe<? extends Webhook> loadWebhook(UUID uuid);

	void updateWebhook(Webhook webhook);

	void deleteWebhook(Webhook webhook);

	void storeWebhook(Webhook webhook);

}
