package io.metaloom.api;

import io.metaloom.loom.api.options.LoomOptions;
import io.vertx.core.ServiceHelper;

public interface Loom {

	public static final String PREFIX = "loom";
	public static final String VERSION = "1_0";

	static LoomFactory factory = ServiceHelper.loadFactory(LoomFactory.class);

	/**
	 * Returns the initialized instance.
	 * 
	 * @param options
	 * 
	 * @return Fluent API
	 */
	public static Loom create(LoomOptions options) {
		options.validate();
		return factory.create(options);
	}

	/**
	 * Start MetaLoom Loom. This will effectively block until {@link #shutdown()} is called from another thread. This method will initialize the dagger context
	 * and deploy mandatory services.
	 * 
	 * @return Fluent API
	 * @throws Exception
	 */
	Loom run() throws Exception;

	Loom run(boolean block) throws Exception;

	/**
	 * Shutdown the instance and terminate the JVM.
	 * 
	 * @param code
	 *            Exit code to return
	 */
	public void shutdownAndTerminate(int i);

	/**
	 * Shutdown the running instance.
	 */
	void shutdown();

	void dontExit() throws InterruptedException;

}
