package io.metaloom.loom.db.model.tag.impl;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.tag.Tag;

public class TagImpl extends AbstractCUDElement implements Tag {

	private String name;
	private String collectionName;

	public TagImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Tag setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getCollection() {
		return collectionName;
	}

	@Override
	public Tag setCollection(String collectionName) {
		this.collectionName = collectionName;
		return this;
	}

}
