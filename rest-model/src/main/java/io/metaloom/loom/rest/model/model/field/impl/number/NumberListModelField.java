package io.metaloom.loom.rest.model.model.field.impl.number;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class NumberListModelField extends AbstractListModelField {

	@Override
	public NumberListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getListType() {
		return FieldType.NUMBER;
	}

}
