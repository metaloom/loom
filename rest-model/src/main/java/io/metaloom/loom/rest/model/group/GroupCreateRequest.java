package io.metaloom.loom.rest.model.group;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class GroupCreateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Name of the group")
	private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private Map<String, String> meta;

	public GroupCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public GroupCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public GroupCreateRequest setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

}
