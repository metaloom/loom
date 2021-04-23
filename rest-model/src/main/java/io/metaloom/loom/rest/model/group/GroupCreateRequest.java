package io.metaloom.loom.rest.model.group;

import io.metaloom.loom.rest.model.RestModel;

public class GroupCreateRequest implements RestModel {

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
