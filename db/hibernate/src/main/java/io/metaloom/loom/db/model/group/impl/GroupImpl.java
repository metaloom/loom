package io.metaloom.loom.db.model.group.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.group.Group;
import io.vertx.core.json.JsonObject;

@Entity
@Table(name = "groups")
public class GroupImpl extends AbstractCUDElement implements Group {

	@Size(max = 128)
	private String name;

	@Column(columnDefinition = "jsonb")
	@Type(type = "io.metaloom.loom.db.hib.types.Json")
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
