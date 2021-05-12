package io.metaloom.loom.db.extension;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.vertx.core.json.JsonObject;

public class FsExtensionImpl extends AbstractFSCUDElement implements LoomExtension {

	private String url;
	private JsonObject meta;

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public LoomExtension setURL(String url) {
		this.url = url;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public LoomExtension setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
