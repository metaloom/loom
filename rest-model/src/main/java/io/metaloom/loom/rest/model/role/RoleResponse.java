package io.metaloom.loom.rest.model.role;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class RoleResponse extends AbstractCreatorEditorRestResponse {

	private String name;

	public RoleResponse() {
	}

	public String getName() {
		return name;
	}

	public RoleResponse setName(String name) {
		this.name = name;
		return this;
	}

}
