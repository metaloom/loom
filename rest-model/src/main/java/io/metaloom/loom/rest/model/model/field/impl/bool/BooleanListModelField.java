package io.metaloom.loom.rest.model.model.field.impl.bool;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class BooleanListModelField extends AbstractListModelField {

	@Override
	public BooleanListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public BooleanListModelField setI18N(Boolean i18n) {
		super.setI18N(i18n);
		return this;
	}

	@Override
	public BooleanListModelField setIndexing(Boolean indexing) {
		super.setIndexing(indexing);
		return this;
	}

	@Override
	public BooleanListModelField setRequired(Boolean required) {
		super.setRequired(required);
		return this;
	}

	@Override
	public FieldType getListType() {
		return FieldType.BOOLEAN;
	}

}
