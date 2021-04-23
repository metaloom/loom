package io.metaloom.loom.rest.model.model.field.impl.text;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class TextListModelField extends AbstractListModelField {

	@Override
	public TextListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.LIST;
	}

	@Override
	public FieldType getListType() {
		return FieldType.TEXT;
	}

}
