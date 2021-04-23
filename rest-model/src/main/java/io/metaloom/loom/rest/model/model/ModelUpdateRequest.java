package io.metaloom.loom.rest.model.model;

import io.metaloom.loom.rest.model.RestModel;

public class ModelUpdateRequest implements RestModel {

	public String name;

	public ModelUpdateRequest() {
	}

	public String getName() {
		return name;
	}

	public ModelUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}
}
