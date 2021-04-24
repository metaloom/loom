package io.metaloom.loom.rest.model.content.field;

import io.metaloom.loom.rest.model.model.field.FieldType;

public abstract class AbstractListContentField extends AbstractContentField {

	abstract public FieldType getListType();

	@Override
	public FieldType getType() {
		return FieldType.LIST;
	}
}
