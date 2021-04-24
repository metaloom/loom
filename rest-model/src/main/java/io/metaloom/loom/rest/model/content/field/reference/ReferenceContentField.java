package io.metaloom.loom.rest.model.content.field.reference;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.content.field.AbstractContentField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class ReferenceContentField extends AbstractContentField {

	@JsonPropertyDescription("Reference to the element.")
	private String uuid;

	@Override
	public ReferenceContentField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.REFERENCE;
	}

	public String getUuid() {
		return uuid;
	}

	public ReferenceContentField setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}
}
