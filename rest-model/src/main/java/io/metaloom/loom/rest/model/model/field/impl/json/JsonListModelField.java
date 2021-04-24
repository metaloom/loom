package io.metaloom.loom.rest.model.model.field.impl.json;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class JsonListModelField extends AbstractListModelField {

	@Override
	public JsonListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getListType() {
		return FieldType.JSON;
	}

}
