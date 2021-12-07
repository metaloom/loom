package io.metaloom.loom.db.model.extension.impl;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.extension.Extension;
import io.vertx.core.json.JsonObject;

public class ExtensionImpl extends AbstractCUDElement implements Extension {

	private String url;
	private JsonObject meta;

	public ExtensionImpl(String url) {
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Extension setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public Extension setURL(String url) {
		this.url = url;
		return this;
	}

}
