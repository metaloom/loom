package io.metaloom.loom.rest.model.model.field.impl.asset;

import io.metaloom.loom.rest.model.model.field.AbstractModelField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class AssetModelField extends AbstractModelField {

	@Override
	public AssetModelField setName(String name) {
		super.setName(name);
		return this;
	}

	@Override
	public FieldType getType() {
		return FieldType.ASSET;
	}
}
