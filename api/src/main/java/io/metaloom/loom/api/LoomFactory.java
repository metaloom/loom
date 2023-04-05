package io.metaloom.loom.api;

import io.metaloom.loom.api.options.LoomOptions;

public interface LoomFactory {

	/**
	 * Return a new instance of loom.
	 * 
	 * @return Loom instance
	 */
	Loom create();

	/**
	 * Return a new instance of loom.
	 * 
	 * @param options
	 *            Loom options
	 * @return Loom instance
	 */
	Loom create(LoomOptions options);
}
