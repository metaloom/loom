package io.metaloom.loom.container.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.Loom;
import io.metaloom.loom.api.options.LoomOptions;

public class ServerRunner {

	public static final Logger log = LoggerFactory.getLogger(ServerRunner.class);

	public static void main(String[] args) {
		LoomOptions options = new LoomOptions();
		Loom loom = Loom.create(options);
		try {
			loom.run();
		} catch (Throwable t) {
			log.error("Error while starting loom. Invoking shutdown.", t);
			loom.shutdownAndTerminate(10);
		}
	}

}
