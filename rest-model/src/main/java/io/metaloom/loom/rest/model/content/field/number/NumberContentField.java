package io.metaloom.loom.rest.model.content.field.number;

import io.metaloom.loom.rest.model.content.field.AbstractContentField;

public class NumberContentField extends AbstractContentField {

	@Override
	public NumberContentField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public String getType() {
		return "number";
	}
}
