package io.metaloom.loom.rest.model.model.field.impl.date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;
import io.metaloom.loom.rest.model.model.field.ModelField;

@JsonPropertyOrder({ "name", "type", "i18N", "indexing", "required" })
public class DateModelField extends AbstractModelField {

	@Override
	public DateModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public DateModelField setI18N(Boolean i18n) {
		super.setI18N(i18n);
		return this;
	}

	@Override
	public DateModelField setIndexing(Boolean indexing) {
		super.setIndexing(indexing);
		return this;
	}

	@Override
	public DateModelField setRequired(Boolean required) {
		super.setRequired(required);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.DATE;
	}
}
