package io.metaloom.loom.rest.model.content.field.bool;

import io.metaloom.loom.rest.model.content.field.AbstractContentField;

public class BooleanContentField extends AbstractContentField {

	private Boolean value;

	@Override
	public BooleanContentField setName(String name) {
		super.setName(name);
		return this;
	}

	public Boolean getValue() {
		return value;
	}

	public BooleanContentField setValue(Boolean value) {
		this.value = value;
		return this;
	}

	@Override
	public String getType() {
		return "boolean";
	}
}
