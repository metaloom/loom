package io.metaloom.loom.rest.model;

import io.metaloom.loom.api.json.JsonUtil;

/**
 * Marker interface for all REST models.
 */
public interface RestModel {

	/**
	 * Transforms the model into a JSON string.
	 * 
	 * @return
	 */
	default String toJson() {
		return JsonUtil.toJson(this);
	}
}
