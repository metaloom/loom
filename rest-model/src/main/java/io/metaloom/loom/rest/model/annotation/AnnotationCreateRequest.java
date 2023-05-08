package io.metaloom.loom.rest.model.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.vertx.core.json.JsonObject;

public class AnnotationCreateRequest implements RestRequestModel, MetaModel<AnnotationCreateRequest> {

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private JsonObject meta;

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public AnnotationCreateRequest setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public AnnotationCreateRequest self() {
		return this;
	}

}
