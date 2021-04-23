package io.metaloom.loom.rest.model.group;

import io.metaloom.loom.rest.model.RestModel;

public class GroupUpdateRequest implements RestModel {

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
