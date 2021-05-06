package io.metaloom.loom.db.jooq.dagger;

import javax.inject.Singleton;

import org.jooq.Configuration;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXGenericQueryExecutor;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.reactivex.Single;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.reactivex.sqlclient.Pool;
import io.vertx.sqlclient.PoolOptions;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.db.jooq.tables.daos.RoleGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.UserGroupDao;
import io.vertx.reactivex.sqlclient.SqlClient;

/**
 * Provider for the generated Jooq DAOs
 */
@Module
public class JooqNativeDaoModule {

	@Provides
	@Singleton
	public SqlClient rxSqlClient(Vertx vertx) {
		PgConnectOptions config = new PgConnectOptions().setHost("127.0.0.1").setPort(5432).setUser("postgres").setDatabase("loom")
			.setPassword("finger");
		PgPool client = PgPool.pool(vertx, config, new PoolOptions().setMaxSize(32));
		Pool rxPgClient = new io.vertx.reactivex.sqlclient.Pool(client);
		return rxPgClient;
	}

	@Provides
	@Singleton
	public Configuration configuration() {
		Configuration configuration = new DefaultConfiguration();
		configuration.set(SQLDialect.POSTGRES);
		return configuration;
	}

	@Provides
	public UserGroupDao userGroupDao(Configuration configuration, SqlClient rxClient) {
		return new UserGroupDao(configuration, rxClient);
	}

	@Provides
	public RoleGroupDao roleGroupDao(Configuration configuration, SqlClient rxClient) {
		return new RoleGroupDao(configuration, rxClient);
	}
}
