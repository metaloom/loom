package io.metaloom.loom.rest.model.project;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class ProjectCreateRequest extends AbstractMetaModel<ProjectCreateRequest> implements RestRequestModel {

	private String name;

	public String getName() {
		return name;
	}

	public ProjectCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public ProjectCreateRequest self() {
		return this;
	}

}
