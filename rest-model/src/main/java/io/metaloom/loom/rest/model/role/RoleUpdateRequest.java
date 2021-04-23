package io.metaloom.loom.rest.model.role;

import io.metaloom.loom.rest.model.RestModel;

public class RoleUpdateRequest implements RestModel {

	private String name;

	public RoleUpdateRequest() {
	}

	public String getName() {
		return name;
	}

	public RoleUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}

}
