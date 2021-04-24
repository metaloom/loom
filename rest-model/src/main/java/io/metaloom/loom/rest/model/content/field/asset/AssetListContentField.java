package io.metaloom.loom.rest.model.content.field.asset;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.rest.model.content.field.AbstractListContentField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class AssetListContentField extends AbstractListContentField {

	private List<AssetContentField> fields;

	@Override
	public FieldType getListType() {
		return FieldType.ASSET;
	}

	public List<AssetContentField> getFields() {
		return fields;
	}

	public AssetListContentField setFields(List<AssetContentField> fields) {
		this.fields = fields;
		return this;
	}

	public AssetListContentField addField(AssetContentField field) {
		if (fields == null) {
			fields = new ArrayList<>();
		}
		fields.add(field);
		return this;
	}

}
