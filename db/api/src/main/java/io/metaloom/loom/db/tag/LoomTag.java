package io.metaloom.loom.db.tag;

import io.metaloom.loom.db.CUDElement;

public interface LoomTag extends CUDElement {

	String getName();

	LoomTag setName(String name);

	String getCollection();

	LoomTag setCollection(String collectionName);
}
