package io.metaloom.loom.db.fs.dao.extension;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.extension.Extension;
import io.vertx.core.json.JsonObject;

public class FsExtensionImpl extends AbstractFSCUDElement implements Extension {

	private String url;
	private JsonObject meta;

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public Extension setURL(String url) {
		this.url = url;
		return this;
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

}