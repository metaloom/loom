package io.metaloom.loom.db.model.role.impl;

import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.role.Role;
import io.vertx.core.json.JsonObject;

public class RoleImpl extends AbstractCUDElement implements Role {

	private String name;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomElement setMeta(JsonObject meta) {
		// TODO Auto-generated method stub
		return null;
	}

}
