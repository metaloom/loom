package io.metaloom.loom.db;

import io.vertx.core.json.JsonObject;

/**
 * Meta elements are elements which store additional meta properties (JSON).
 */
public interface MetaElement extends Element {

	/**
	 * Return the meta properties.
	 * 
	 * @return
	 */
	JsonObject getMeta();

	/**
	 * Set the meta properties.
	 * 
	 * @param meta
	 * @return Fluent API
	 */
	Element setMeta(JsonObject meta);

}
