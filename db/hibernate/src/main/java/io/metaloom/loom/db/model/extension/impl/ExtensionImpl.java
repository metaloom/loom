package io.metaloom.loom.db.model.extension.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.extension.Extension;
import io.vertx.core.json.JsonObject;

@Entity
@Table(name = "extensions")
public class ExtensionImpl extends AbstractCUDElement implements Extension {

	@NotNull
	@Size(max = 512)
	private String url;

	@Column(columnDefinition = "jsonb")
	@Type(type = "io.metaloom.loom.db.hib.types.Json")
	private JsonObject meta;

	public ExtensionImpl(String url) {
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Extension setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public Extension setURL(String url) {
		this.url = url;
		return this;
	}

}
