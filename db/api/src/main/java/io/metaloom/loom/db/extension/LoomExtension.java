package io.metaloom.loom.db.extension;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;

public interface LoomExtension extends CUDElement, MetaElement {

	/**
	 * Return the URL under which the extension can be reached.
	 * 
	 * @return
	 */
	String getURL();

	/**
	 * Set the connection URL for the extension.
	 * 
	 * @param url
	 * @return
	 */
	LoomExtension setURL(String url);
}
