package io.metaloom.loom.db.model.model;

import io.metaloom.loom.db.CUDElement;

public interface Model extends CUDElement {

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
	Model setName(String name);
}
