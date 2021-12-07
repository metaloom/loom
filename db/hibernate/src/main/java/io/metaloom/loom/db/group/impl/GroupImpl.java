package io.metaloom.loom.db.group.impl;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.group.Group;
import io.vertx.core.json.JsonObject;

public class GroupImpl extends AbstractCUDElement implements Group {

	private String name;

	private JsonObject meta;

	public GroupImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Group setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Group setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
