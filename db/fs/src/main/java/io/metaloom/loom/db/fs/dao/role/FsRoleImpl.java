package io.metaloom.loom.db.fs.dao.role;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.role.Role;
import io.vertx.core.json.JsonObject;

public class FsRoleImpl extends AbstractFSCUDElement implements Role {

	private String name;
	private JsonObject meta;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Role setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Role setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
