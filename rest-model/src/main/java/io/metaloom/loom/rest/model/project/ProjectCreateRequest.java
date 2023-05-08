package io.metaloom.loom.rest.model.project;

import io.metaloom.loom.rest.model.RestRequestModel;

public class ProjectCreateRequest implements RestRequestModel {

	private String name;

	public String getName() {
		return name;
	}

	public ProjectCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

}
