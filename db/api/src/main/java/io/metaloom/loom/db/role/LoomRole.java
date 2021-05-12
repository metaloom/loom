package io.metaloom.loom.db.role;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;

public interface LoomRole extends CUDElement, MetaElement {

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
