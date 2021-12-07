package io.metaloom.loom.db.model.content.impl;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.content.Content;
import io.vertx.core.json.JsonObject;

public class ContentImpl extends AbstractCUDElement implements Content {

	private JsonObject meta;

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Content setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
