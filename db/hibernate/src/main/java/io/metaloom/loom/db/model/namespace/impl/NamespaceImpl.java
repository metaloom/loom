package io.metaloom.loom.db.model.namespace.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.vertx.core.json.JsonObject;

@Entity
@Table(name = "namespaces")
public class NamespaceImpl extends AbstractCUDElement implements Namespace {

	@Size(max = 128)
	private String name;

	@Column(columnDefinition = "jsonb")
	@Type(type = "io.metaloom.loom.db.hib.types.Json")
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
