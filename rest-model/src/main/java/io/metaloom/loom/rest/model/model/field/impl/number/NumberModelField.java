package io.metaloom.loom.rest.model.model.field.impl.number;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

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
