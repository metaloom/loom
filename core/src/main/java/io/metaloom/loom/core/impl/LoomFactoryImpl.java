package io.metaloom.loom.core.impl;

import io.metaloom.loom.api.Loom;
import io.metaloom.loom.api.LoomFactory;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.common.options.LoomOptionsLoader;
import io.metaloom.loom.core.LoomImpl;

public class LoomFactoryImpl implements LoomFactory {

	@Override
	public Loom create() {
		return create(LoomOptionsLoader.createOrLoadOptions());
	}

	@Override
	public Loom create(LoomOptions options) {
		return new LoomImpl(options);
	}
}
