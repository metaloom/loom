package io.metaloom.loom.db;

import java.util.UUID;

public interface Element {

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
	 * @return Fluent API
	 */
	Element setUuid(UUID uuid);
}
