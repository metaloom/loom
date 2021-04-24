package io.metaloom.loom.rest.model.model.field.impl.number;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

@JsonPropertyOrder({ "name", "type", "i18N", "indexing", "required" })
public class NumberModelField extends AbstractModelField {

	@Override
	public NumberModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.NUMBER;
	}

}
