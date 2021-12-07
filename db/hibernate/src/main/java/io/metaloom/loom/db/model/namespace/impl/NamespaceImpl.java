package io.metaloom.loom.db.model.namespace.impl;

import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.vertx.core.json.JsonObject;

public class NamespaceImpl extends AbstractCUDElement implements Namespace {

	private String name;

	public NamespaceImpl(String name) {
		this.name = name;
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
