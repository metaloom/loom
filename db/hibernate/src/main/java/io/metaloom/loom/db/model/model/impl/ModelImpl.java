package io.metaloom.loom.db.model.model.impl;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.model.Model;

public class ModelImpl extends AbstractCUDElement implements Model {

	private String name;

	public ModelImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Model setName(String name) {
		this.name = name;
		return this;
	}

}
