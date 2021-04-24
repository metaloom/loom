package io.metaloom.loom.rest.model.model.field.impl.reference;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class ReferenceListModelField extends AbstractListModelField {

	@Override
	public ReferenceListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public ReferenceListModelField setI18N(Boolean i18n) {
		super.setI18N(i18n);
		return this;
	}

	@Override
	public ReferenceListModelField setIndexing(Boolean indexing) {
		super.setIndexing(indexing);
		return this;
	}

	@Override
	public ReferenceListModelField setRequired(Boolean required) {
		super.setRequired(required);
		return this;
	}

	@Override
	public FieldType getListType() {
		return FieldType.REFERENCE;
	}

}
