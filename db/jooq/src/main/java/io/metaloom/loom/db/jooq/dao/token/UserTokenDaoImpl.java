package io.metaloom.loom.db.jooq.dao.token;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserTokenDao;
import io.metaloom.loom.db.model.user.UserTokenDao;

@Singleton
public class UserTokenDaoImpl extends AbstractJooqDao<JooqUserTokenDao> implements UserTokenDao {

	@Inject
	public UserTokenDaoImpl(JooqUserTokenDao dao, DSLContext ctx) {
		super(dao, ctx);
	}
}
