package io.metaloom.loom.db.model.role;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomMetaElement;

public interface LoomRole extends CUDElement, LoomMetaElement {

	/**
	 * Return the name of the role.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Set the name of the role.
	 * 
	 * @param name
	 * @return Fluent API
	 */
	LoomRole setName(String name);
}
