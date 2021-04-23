package io.metaloom.loom.rest.model.model.field;

import io.metaloom.loom.rest.model.RestModel;

public interface ModelField extends RestModel {

	/**
	 * Return the name of the field within the model.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Set the name of the model.
	 * 
	 * @param name
	 * @return
	 */
	ModelField setName(String name);

	String getType();

	ModelField setType(String type);

	String getListType();

	ModelField setListType(String listType);

}
