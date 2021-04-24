package io.metaloom.loom.rest.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class GroupCreateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Name of the group")
	private String name;

	public GroupCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public GroupCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

}
