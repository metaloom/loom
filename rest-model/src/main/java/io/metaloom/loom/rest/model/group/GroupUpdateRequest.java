package io.metaloom.loom.rest.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class GroupUpdateRequest implements RestModel {

	@JsonProperty(required = false)
	@JsonPropertyDescription("Name of the group")
	private String name;

	public GroupUpdateRequest() {
	}

	public String getName() {
		return name;
	}

	public GroupUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}

}
