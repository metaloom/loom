package io.metaloom.loom.db.model.namespace;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomMetaElement;
import io.metaloom.loom.db.LoomTaggable;

public interface LoomNamespace extends CUDElement, LoomTaggable, LoomMetaElement {

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
