package io.metaloom.loom.db.model.model.impl;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.model.Model;

@Entity
@Table(name= "models")
public class ModelImpl extends AbstractCUDElement implements Model {

	@NotNull
	@Size(max = 128)
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
