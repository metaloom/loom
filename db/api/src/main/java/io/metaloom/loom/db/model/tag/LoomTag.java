package io.metaloom.loom.db.model.tag;

import io.metaloom.loom.db.CUDElement;

/**
 * Tags are elements which can be attached to various other elements (e.g. Namespaces, Contents, Assets)
 */
public interface LoomTag extends CUDElement {

	/**
	 * Return the name of the tag.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Set the tag name.
	 * 
	 * @param name
	 * @return Fluent API
	 */
	LoomTag setName(String name);

	/**
	 * Return the name of the collection of the tag.
	 * 
	 * @return
	 */
	String getCollection();

	/**
	 * Set the name of the collection to which the tag belongs.
	 * 
	 * @param collectionName
	 * @return Fluent API
	 */
	LoomTag setCollection(String collectionName);
}
