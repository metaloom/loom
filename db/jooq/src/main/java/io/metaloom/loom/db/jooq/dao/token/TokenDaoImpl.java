package io.metaloom.loom.db.jooq.dao.token;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTokenDao;
import io.metaloom.loom.db.model.user.TokenDao;

@Singleton
public class TokenDaoImpl extends AbstractJooqDao<JooqTokenDao> implements TokenDao {

	@Inject
	public TokenDaoImpl(JooqTokenDao dao, DSLContext ctx) {
		super(dao, ctx);
	}
}
