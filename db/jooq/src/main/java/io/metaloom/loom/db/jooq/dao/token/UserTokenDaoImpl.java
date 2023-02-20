package io.metaloom.loom.db.jooq.dao.token;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.user.LoomUserTokenDao;

@Singleton
public class UserTokenDaoImpl extends AbstractDao implements LoomUserTokenDao {

	@Inject
	public UserTokenDaoImpl(DSLContext ctx) {
		super(ctx);
	}
}
