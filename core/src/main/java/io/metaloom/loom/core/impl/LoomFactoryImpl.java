package io.metaloom.loom.core.impl;

import io.metaloom.api.Loom;
import io.metaloom.api.LoomFactory;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.common.options.OptionsLoader;
import io.metaloom.loom.core.LoomImpl;

public class LoomFactoryImpl implements LoomFactory {

	@Override
	public Loom create() {
		return create(OptionsLoader.createOrloadOptions());
	}

	@Override
	public Loom create(LoomOptions options) {
		return new LoomImpl(options);
	}
}
