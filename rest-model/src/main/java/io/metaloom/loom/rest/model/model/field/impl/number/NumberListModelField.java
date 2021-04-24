package io.metaloom.loom.rest.model.model.field.impl.number;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;
import io.metaloom.loom.rest.model.model.field.ModelField;

@JsonPropertyOrder({ "name", "type", "i18N", "indexing", "required" })
public class NumberListModelField extends AbstractListModelField {

	@Override
	public NumberListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public NumberListModelField setI18N(Boolean i18n) {
		super.setI18N(i18n);
		return this;
	}

	@Override
	public NumberListModelField setIndexing(Boolean indexing) {
		super.setIndexing(indexing);
		return this;
	}

	@Override
	public NumberListModelField setRequired(Boolean required) {
		super.setRequired(required);
		return this;
	}

	@Override
	public FieldType getListType() {
		return FieldType.NUMBER;
	}

}
