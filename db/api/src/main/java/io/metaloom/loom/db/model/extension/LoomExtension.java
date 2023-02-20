package io.metaloom.loom.db.model.extension;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomMetaElement;

public interface LoomExtension extends CUDElement, LoomMetaElement {

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
