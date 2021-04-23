package io.metaloom.loom.rest.model.model.field.impl;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class DateModelField extends AbstractModelField {

	@Override
	public DateModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.DATE;
	}
}
