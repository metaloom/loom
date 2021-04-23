package io.metaloom.loom.rest.model.role;

import io.metaloom.loom.rest.model.RestModel;

public class RoleCreateRequest implements RestModel {

	private String name;

	public RoleCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public RoleCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

}
