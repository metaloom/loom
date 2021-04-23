package io.metaloom.loom.rest.model.content.field.json;

import io.metaloom.loom.rest.model.content.field.AbstractContentField;

public class JsonContentField extends AbstractContentField {

	@Override
	public JsonContentField setName(String name) {
		super.setName(name);
		return this;
	}
	
	@Override
	public String getType() {
		return "json";
	}
}
