package io.metaloom.loom.db.model.namespace.impl;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.vertx.core.json.JsonObject;

public class NamespaceImpl extends AbstractCUDElement implements Namespace {

	private String name;

	private JsonObject meta;

	public NamespaceImpl(String name) {
		this.name = name;
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

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Namespace setName(String name) {
		this.name = name;
		return this;
	}

}
