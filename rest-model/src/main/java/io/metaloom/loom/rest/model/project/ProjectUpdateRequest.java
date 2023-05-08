package io.metaloom.loom.rest.model.project;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class ProjectUpdateRequest extends AbstractMetaModel<ProjectUpdateRequest> implements RestRequestModel {

	private String name;

	public String getName() {
		return name;
	}

	public ProjectUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public ProjectUpdateRequest self() {
		return this;
	}

}
