package io.metaloom.loom.rest.model.model.field.impl.nested;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

@JsonPropertyOrder({ "name", "type", "i18N", "indexing", "required" })
public class NestedListModelField extends AbstractListModelField {

	@Override
	public NestedListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public NestedListModelField setI18N(Boolean i18n) {
		super.setI18N(i18n);
		return this;
	}

	@Override
	public NestedListModelField setIndexing(Boolean indexing) {
		super.setIndexing(indexing);
		return this;
	}

	@Override
	public NestedListModelField setRequired(Boolean required) {
		super.setRequired(required);
		return this;
	}

	@Override
	public FieldType getListType() {
		return FieldType.NESTED;
	}

}
