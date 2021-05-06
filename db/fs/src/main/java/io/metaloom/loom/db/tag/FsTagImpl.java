package io.metaloom.loom.db.tag;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsTagImpl extends AbstractFSCUDElement implements Tag {

	private String name;

	private String collection;

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
		return collection;
	}

	@Override
	public Tag setCollection(String collectionName) {
		this.collection = collectionName;
		return this;
	}

}
