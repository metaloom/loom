package io.metaloom.loom.db.model.group;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;

public interface Group extends CUDElement, MetaElement {

	/**
	 * Return the name of the group.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Set the name of the group.
	 * 
	 * @param name
	 * @return
	 */
	Group setName(String name);

}
