package io.metaloom.loom.rest.model.content.field.bool;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.content.field.AbstractContentField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class BooleanContentField extends AbstractContentField {

	@JsonPropertyDescription("The boolean value for the field.")
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
	public FieldType getType() {
		return FieldType.BOOLEAN;
	}
}
