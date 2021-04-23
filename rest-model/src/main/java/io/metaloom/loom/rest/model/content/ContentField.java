package io.metaloom.loom.rest.model.content;

import io.metaloom.loom.rest.model.RestModel;

public class ContentField implements RestModel {

	private String name;

	public ContentField() {
	}

	public String getName() {
		return name;
	}

	public ContentField setName(String name) {
		this.name = name;
		return this;
	}

}
