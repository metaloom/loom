package io.metaloom.loom.db;

import java.util.UUID;

public interface LoomElement {

	/**
	 * Return the UUID of the element.
	 * 
	 * @return
	 */
	UUID getUuid();

	/**
	 * Set the UUID of the element.
	 * 
	 * @param uuid
	 */
	void setUuid(UUID uuid);
}
