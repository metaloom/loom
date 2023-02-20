package io.metaloom.loom.db.jooq;

import org.jooq.DSLContext;

public abstract class AbstractDao {

	private DSLContext ctx;

	public AbstractDao(DSLContext ctx) {
		this.ctx = ctx;
	}

	protected DSLContext context() {
		return ctx;
	}

}
