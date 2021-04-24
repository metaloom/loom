package io.metaloom.loom.rest.model.content.field.text;

import io.metaloom.loom.rest.model.content.field.AbstractListContentField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class TextListContentField extends AbstractListContentField {

	@Override
	public FieldType getListType() {
		return FieldType.TEXT;
	}

}
