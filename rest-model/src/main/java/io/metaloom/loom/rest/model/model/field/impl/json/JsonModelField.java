package io.metaloom.loom.rest.model.model.field.impl.json;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class JsonModelField extends AbstractModelField {

	@Override
	public JsonModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.JSON;
	}
}
