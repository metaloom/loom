package io.metaloom.loom.db;

import io.vertx.core.json.JsonObject;

/**
 * Meta elements are elements which store additional meta properties (JSON).
 */
public interface MetaElement extends LoomElement {

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
	LoomElement setMeta(JsonObject meta);

}
