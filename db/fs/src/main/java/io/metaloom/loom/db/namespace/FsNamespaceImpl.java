package io.metaloom.loom.db.namespace;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.vertx.core.json.JsonObject;

public class FsNamespaceImpl extends AbstractFSCUDElement implements Namespace {

	private String name;

	private JsonObject meta;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Namespace setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Namespace setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
