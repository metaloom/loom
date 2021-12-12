package io.metaloom.loom.db.fs.dao.tag;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.tag.Tag;

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
