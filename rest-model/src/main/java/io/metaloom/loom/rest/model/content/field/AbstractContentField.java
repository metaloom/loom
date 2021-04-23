package io.metaloom.loom.rest.model.content.field;

import io.metaloom.loom.rest.model.content.ContentField;

public abstract class AbstractContentField implements ContentField {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ContentField setName(String name) {
		this.name = name;
		return this;
	}

}
