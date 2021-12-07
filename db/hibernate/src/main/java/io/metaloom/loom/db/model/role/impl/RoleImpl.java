package io.metaloom.loom.db.model.role.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.role.Role;
import io.vertx.core.json.JsonObject;

@Entity
@Table(name= "roles")
public class RoleImpl extends AbstractCUDElement implements Role {

	@NotNull
	@Size(max = 128)
	private String name;

	@Column(columnDefinition = "jsonb")
	@Type(type = "io.metaloom.loom.db.hib.types.Json")
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
