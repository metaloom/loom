package io.metaloom.loom.rest.builder.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.rest.builder.LoomModelBuilder;

@Singleton
public class LoomModelBuilderImpl implements LoomModelBuilder {

	private final DaoCollection daos;

	@Inject
	public LoomModelBuilderImpl(DaoCollection daos) {
		this.daos = daos;
	}

	@Override
	public DaoCollection daos() {
		return daos;
	}

}
