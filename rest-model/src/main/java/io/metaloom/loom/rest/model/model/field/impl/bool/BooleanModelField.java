package io.metaloom.loom.rest.model.model.field.impl.bool;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class BooleanModelField extends AbstractModelField {

	@Override
	public BooleanModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.BOOLEAN;
	}
}
