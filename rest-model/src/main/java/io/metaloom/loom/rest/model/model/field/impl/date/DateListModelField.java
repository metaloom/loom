package io.metaloom.loom.rest.model.model.field.impl.date;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class DateListModelField extends AbstractListModelField {

	@Override
	public DateListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getListType() {
		return FieldType.DATE;
	}

}
