package io.metaloom.loom.db.user;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.UserTokenDao;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqUserTokenDaoImpl extends UserTokenDao implements LoomUserTokenDao {

	@Inject
	public JooqUserTokenDaoImpl(Configuration configuration, SqlClient rxClient) {
		super(configuration, rxClient);
	}

}
