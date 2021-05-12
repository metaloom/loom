package io.metaloom.loom.db.webhook;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.vertx.core.json.JsonObject;

public class FsWebhookImpl extends AbstractFSCUDElement implements LoomWebhook {

	private String url;
	private JsonObject meta;

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public LoomWebhook setURL(String url) {
		this.url = url;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public LoomWebhook setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
