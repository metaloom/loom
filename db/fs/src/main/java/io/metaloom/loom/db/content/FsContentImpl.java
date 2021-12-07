package io.metaloom.loom.db.content;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.content.Content;
import io.vertx.core.json.JsonObject;

public class FsContentImpl extends AbstractFSCUDElement implements Content {

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
