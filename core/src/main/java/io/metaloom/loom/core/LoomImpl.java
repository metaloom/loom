package io.metaloom.loom.core;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.Loom;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.core.dagger.DaggerLoomCoreComponent;
import io.metaloom.loom.core.dagger.LoomCoreComponent;

public class LoomImpl implements Loom {

	private static final Logger log = LoggerFactory.getLogger(LoomImpl.class);

	private LoomOptions options;

	private boolean shutdown = true;

	private CountDownLatch latch = new CountDownLatch(1);

	private LoomCoreComponent loomInternal;

	public LoomImpl(LoomOptions options) {
		this.options = options;
	}

	@Override
	public Loom run() throws Exception {
		run(true);
		return this;
	}

	@Override
	public Loom run(boolean block) throws Exception {
		try {
			log.info("Starting loom...");
			shutdown = false;
			loomInternal = DaggerLoomCoreComponent.builder().configuration(options).build();
			loomInternal.boot().init();
		} catch (Exception e) {
			log.error("Error while starting loom", e);
		}

		if (block) {
			dontExit();
		}
		return this;
	}

	@Override
	public void shutdown() {
		if (shutdown) {
			log.info("Instance is already shut down...");
			return;
		}
		log.info("Loom shutting down...");
		try {
			loomInternal.boot().deinit();
		} catch (Exception e) {
			log.error("Error while shutting down", e);
		}

		try {
			latch.countDown();
		} catch (Exception e) {
			log.debug("Error while releasing latch. Maybe it was already released.", e);
		}
		shutdown = true;

	}

	@Override
	public void dontExit() throws InterruptedException {
		latch.await();
	}

	@Override
	public void shutdownAndTerminate(int code) {
		Runtime.getRuntime().exit(code);
	}

}
