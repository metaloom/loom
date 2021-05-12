package io.metaloom.loom.db.content;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.vertx.core.json.JsonObject;

public class FsContentImpl extends AbstractFSCUDElement implements LoomContent {

	private JsonObject meta;

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public LoomContent setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
