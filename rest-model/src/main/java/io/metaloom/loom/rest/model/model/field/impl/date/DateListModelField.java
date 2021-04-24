package io.metaloom.loom.rest.model.model.field.impl.date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

@JsonPropertyOrder({ "name", "type", "i18N", "indexing", "required" })
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
