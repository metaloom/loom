package io.metaloom.loom.rest.model.model;

import io.metaloom.loom.rest.model.RestModel;

public class ModelCreateRequest implements RestModel {

	private String name;

	public ModelCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public ModelCreateRequest setName(String name) {
		this.name = name;
		return this;
	}
}
