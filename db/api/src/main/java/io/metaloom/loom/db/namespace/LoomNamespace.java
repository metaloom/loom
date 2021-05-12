package io.metaloom.loom.db.namespace;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;
import io.metaloom.loom.db.Taggable;

public interface LoomNamespace extends CUDElement, Taggable, MetaElement {

	/**
	 * Return the name of the namespace.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Set the name of the namespace.
	 * 
	 * @param name
	 * @return
	 */
	LoomNamespace setName(String name);

}
