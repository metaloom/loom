package io.metaloom.loom.rest.model.tag;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.RestModel;

public interface TagModel<T extends TagModel<T>> extends MetaModel<T>, RestModel {

	String getName();

	T setName(String name);

	String getCollection();

	T setCollection(String collection);

}
