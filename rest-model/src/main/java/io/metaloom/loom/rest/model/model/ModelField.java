package io.metaloom.loom.rest.model.model;

import io.metaloom.loom.rest.model.RestModel;

public class ModelField implements RestModel {

	private String name;

	private String type;

	private String listType;

	public ModelField() {
	}

	public String getName() {
		return name;
	}

	public ModelField setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public ModelField setType(String type) {
		this.type = type;
		return this;
	}

	public String getListType() {
		return listType;
	}

	public ModelField setListType(String listType) {
		this.listType = listType;
		return this;
	}

}
