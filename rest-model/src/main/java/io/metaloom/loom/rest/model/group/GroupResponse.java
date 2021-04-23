package io.metaloom.loom.rest.model.group;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class GroupResponse extends AbstractCreatorEditorRestResponse {

	private String name;

	public GroupResponse() {
	}

	public String getName() {
		return name;
	}

	public GroupResponse setName(String name) {
		this.name = name;
		return this;
	}
}
