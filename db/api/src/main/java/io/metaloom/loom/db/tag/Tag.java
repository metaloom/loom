package io.metaloom.loom.db.tag;

import io.metaloom.loom.db.CUDElement;

public interface Tag extends CUDElement {

	String getName();

	Tag setName(String name);

	String getCollection();

	Tag setCollection(String collectionName);
}
