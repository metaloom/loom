package io.metaloom.loom.rest.model.content.field.date;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.content.field.AbstractContentField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class DateContentField extends AbstractContentField {

	//TODO support durations as well? (Can be modeled with two fields?)
	@JsonPropertyDescription("The date value")
	private String value;

	@Override
	public DateContentField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.DATE;
	}

	public String getValue() {
		return value;
	}

	public DateContentField setValue(String value) {
		this.value = value;
		return this;
	}
}
