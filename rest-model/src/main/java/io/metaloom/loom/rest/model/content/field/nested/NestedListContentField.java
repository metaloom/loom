package io.metaloom.loom.rest.model.content.field.nested;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.rest.model.content.ContentField;
import io.metaloom.loom.rest.model.content.field.AbstractListContentField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class NestedListContentField extends AbstractListContentField {

	private List<List<ContentField>> items;

	@Override
	public FieldType getListType() {
		return FieldType.NESTED;
	}

	@Override
	public NestedListContentField setName(String name) {
		super.setName(name);
		return this;
	}

	public List<List<ContentField>> getItems() {
		return items;
	}

	public NestedListContentField setItems(List<List<ContentField>> items) {
		this.items = items;
		return this;
	}

	public NestedListContentField addFields(List<ContentField> fields) {
		if (items == null) {
			items = new ArrayList<>();
		}
		this.items.add(fields);
		return this;
	}

}
