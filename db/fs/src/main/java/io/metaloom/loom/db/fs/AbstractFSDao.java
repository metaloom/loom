package io.metaloom.loom.db.fs;

import io.metaloom.loom.db.DaoCollection;

public abstract class AbstractFSDao {

	private DaoCollection daos;

	public AbstractFSDao(DaoCollection daos) {
		this.daos = daos;
	}

	abstract protected FSType getType();
	
	public DaoCollection daos() {
		return daos;
	}
}
