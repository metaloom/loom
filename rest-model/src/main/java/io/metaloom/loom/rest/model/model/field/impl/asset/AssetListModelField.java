package io.metaloom.loom.rest.model.model.field.impl.asset;

import io.metaloom.loom.rest.model.model.field.AbstractListModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class AssetListModelField extends AbstractListModelField {

	@Override
	public AssetListModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public AssetListModelField setI18N(Boolean i18n) {
		super.setI18N(i18n);
		return this;
	}

	@Override
	public AssetListModelField setIndexing(Boolean indexing) {
		super.setIndexing(indexing);
		return this;
	}

	@Override
	public AssetListModelField setRequired(Boolean required) {
		super.setRequired(required);
		return this;
	}

	@Override
	public FieldType getListType() {
		return FieldType.ASSET;
	}

}
