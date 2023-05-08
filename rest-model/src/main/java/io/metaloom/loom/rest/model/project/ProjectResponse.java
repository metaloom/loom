package io.metaloom.loom.rest.model.project;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class ProjectResponse extends AbstractCreatorEditorRestResponse<ProjectResponse> {

	private String name;

	public String getName() {
		return name;
	}

	public ProjectResponse setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public ProjectResponse self() {
		return this;
	}

}
