package io.metaloom.loom.rest.model.content.field.bool;

import io.metaloom.loom.rest.model.content.field.AbstractListContentField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class BooleanListContentField extends AbstractListContentField {

	@Override
	public FieldType getListType() {
		return FieldType.BOOLEAN;
	}

}
