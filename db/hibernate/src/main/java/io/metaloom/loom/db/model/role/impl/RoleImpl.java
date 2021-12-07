package io.metaloom.loom.db.model.role.impl;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.role.Role;
import io.vertx.core.json.JsonObject;

public class RoleImpl extends AbstractCUDElement implements Role {

	private String name;

	private JsonObject meta;

	public RoleImpl(String name) {
		this.name = name;
	}

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
