package io.metaloom.loom.db.fs.dao.webhook;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.webhook.Webhook;
import io.vertx.core.json.JsonObject;

public class FsWebhookImpl extends AbstractFSCUDElement implements Webhook {

	private String url;
	private JsonObject meta;

	public FsWebhookImpl(String url) {
		this.url = url;
	}

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public Webhook setURL(String url) {
		this.url = url;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Webhook setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
