package io.metaloom.loom.db.role;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.vertx.core.json.JsonObject;

public class FsRoleImpl extends AbstractFSCUDElement implements LoomRole {

	private String name;
	private JsonObject meta;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LoomRole setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public LoomRole setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
