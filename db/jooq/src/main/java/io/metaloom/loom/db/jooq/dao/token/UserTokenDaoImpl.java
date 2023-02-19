package io.metaloom.loom.db.jooq.dao.token;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.user.UserTokenDao;

@Singleton
public class UserTokenDaoImpl extends AbstractDao implements UserTokenDao {

	@Inject
	public UserTokenDaoImpl() {
		// TODO Auto-generated constructor stub
	}
}
