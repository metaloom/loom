package io.metaloom.loom.db.model.content.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.content.Content;
import io.vertx.core.json.JsonObject;

@Entity
@Table(name= "contents")
public class ContentImpl extends AbstractCUDElement implements Content {

	@Column(columnDefinition = "jsonb")
	@Type(type = "io.metaloom.loom.db.hib.types.Json")
	private JsonObject meta;

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Content setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
