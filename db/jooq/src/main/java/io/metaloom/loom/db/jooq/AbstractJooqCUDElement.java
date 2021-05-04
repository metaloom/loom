package io.metaloom.loom.db.jooq;

public abstract class AbstractJooqCUDElement {

	protected JooqDaoCollection daos;

	public AbstractJooqCUDElement(JooqDaoCollection daos) {
		this.daos = daos;
	}
}
