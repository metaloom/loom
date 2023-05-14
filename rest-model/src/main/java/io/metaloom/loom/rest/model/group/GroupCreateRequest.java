package io.metaloom.loom.rest.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.vertx.core.json.JsonObject;

public class GroupCreateRequest implements RestRequestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Name of the group")
	private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private JsonObject meta;

	public GroupCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public GroupCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public JsonObject getMeta() {
		return meta;
	}

	public GroupCreateRequest setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

}
