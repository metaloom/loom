package io.metaloom.loom.db.model;

import io.metaloom.loom.db.CUDElement;

public interface LoomModel extends CUDElement {

	/**
	 * Return the name of the model.
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
	LoomModel setName(String name);
}
