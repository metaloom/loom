package io.metaloom.loom.db.namespace;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.vertx.core.json.JsonObject;

public class FsNamespaceImpl extends AbstractFSCUDElement implements LoomNamespace {

	private String name;

	private JsonObject meta;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LoomNamespace setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public LoomNamespace	 setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
