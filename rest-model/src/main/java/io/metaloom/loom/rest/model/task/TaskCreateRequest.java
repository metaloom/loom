package io.metaloom.loom.rest.model.task;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class TaskCreateRequest extends AbstractMetaModel<TaskCreateRequest> implements RestRequestModel {

	private String title;

	private String description;

	public String getTitle() {
		return title;
	}

	public TaskCreateRequest setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public TaskCreateRequest setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public TaskCreateRequest self() {
		return this;
	}

}
