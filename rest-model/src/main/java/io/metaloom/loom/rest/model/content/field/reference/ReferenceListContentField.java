package io.metaloom.loom.rest.model.content.field.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.metaloom.loom.rest.model.content.ContentField;
import io.metaloom.loom.rest.model.content.field.AbstractListContentField;
import io.metaloom.loom.rest.model.model.field.FieldType;

public class ReferenceListContentField extends AbstractListContentField {

	private List<UUID> items;

	@Override
	public FieldType getListType() {
		return FieldType.REFERENCE;
	}

	@Override
	public ContentField setName(String name) {
		super.setName(name);
		return this;
	}

	public List<UUID> getItems() {
		return items;
	}

	public ReferenceListContentField setItems(List<UUID> items) {
		this.items = items;
		return this;
	}

	public ReferenceListContentField addReference(UUID uuid) {
		if (items == null) {
			items = new ArrayList<>();
		}
		items.add(uuid);
		return this;
	}

}
