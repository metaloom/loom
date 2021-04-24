package io.metaloom.loom.rest.model.model.field.impl.nested;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class NestedModelField extends AbstractModelField {

	@Override
	public NestedModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public NestedModelField setI18N(Boolean i18n) {
		super.setI18N(i18n);
		return this;
	}

	@Override
	public NestedModelField setIndexing(Boolean indexing) {
		super.setIndexing(indexing);
		return this;
	}

	@Override
	public NestedModelField setRequired(Boolean required) {
		super.setRequired(required);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.NESTED;
	}

}
