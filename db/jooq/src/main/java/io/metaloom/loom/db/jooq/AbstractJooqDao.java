package io.metaloom.loom.db.jooq;

import org.jooq.DAO;
import org.jooq.DSLContext;

import io.metaloom.loom.db.Dao;
import io.metaloom.loom.db.jooq.wrapper.WrapperDaoHelper;

public abstract class AbstractJooqDao<D extends DAO<?, ?, ?>> implements Dao, WrapperDaoHelper {

	private final D dao;

	private final DSLContext ctx;

	public AbstractJooqDao(D dao, DSLContext ctx) {
		this.dao = dao;
		this.ctx = ctx;
	}

	protected DSLContext ctx() {
		return ctx;
	}

	public D dao() {
		return dao;
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public void clear() {
		//ctx().truncate(io.metaloom.loom.db.jooq.tables.Face.FACE).cascade().execute();
		ctx().deleteFrom(dao().getTable()).execute();
	}

}
