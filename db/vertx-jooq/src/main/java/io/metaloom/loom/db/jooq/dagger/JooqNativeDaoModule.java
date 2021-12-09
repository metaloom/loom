package io.metaloom.loom.db.jooq.dagger;

import javax.inject.Singleton;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.db.jooq.tables.daos.AssetBinaryDao;
import io.metaloom.loom.db.jooq.tables.daos.AssetTimelineDao;
import io.metaloom.loom.db.jooq.tables.daos.ContentUserMetaDao;
import io.metaloom.loom.db.jooq.tables.daos.FieldAssetDao;
import io.metaloom.loom.db.jooq.tables.daos.FieldReferenceDao;
import io.metaloom.loom.db.jooq.tables.daos.LanguageDao;
import io.metaloom.loom.db.jooq.tables.daos.ModelVersionDao;
import io.metaloom.loom.db.jooq.tables.daos.RoleGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.RolePermissionDao;
import io.metaloom.loom.db.jooq.tables.daos.TagAssetDao;
import io.metaloom.loom.db.jooq.tables.daos.TagContentDao;
import io.metaloom.loom.db.jooq.tables.daos.UserGroupDao;
import io.metaloom.loom.options.DatabaseOptions;
import io.vertx.core.Vertx;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.reactivex.sqlclient.Pool;
import io.vertx.reactivex.sqlclient.SqlClient;
import io.vertx.sqlclient.PoolOptions;

/**
 * Provider for the generated Jooq DAOs
 */
@Module
public class JooqNativeDaoModule {

	@Provides
	@Singleton
	public SqlClient rxSqlClient(Vertx vertx, DatabaseOptions dbOptions) {
		String host = dbOptions.getHost();
		int port = dbOptions.getPort();
		String username = dbOptions.getUsername();
		String password = dbOptions.getPassword();
		String database = dbOptions.getDatabaseName();

		PgConnectOptions config = new PgConnectOptions()
			.setHost(host)
			.setPort(port)
			.setUser(username)
			.setPassword(password)
			.setDatabase(database);

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
	@Singleton
	public UserGroupDao userGroupDao(Configuration configuration, SqlClient rxClient) {
		return new UserGroupDao(configuration, rxClient);
	}

	@Provides
	@Singleton
	public RoleGroupDao roleGroupDao(Configuration configuration, SqlClient rxClient) {
		return new RoleGroupDao(configuration, rxClient);
	}

	// @Provides
	// @Singleton
	// public UserDao userDao(Configuration configuration, SqlClient rxClient) {
	// return new UserDao(configuration, rxClient);
	// }
	//
	// @Provides
	// @Singleton
	// public GroupDao groupDao(Configuration configuration, SqlClient rxClient) {
	// return new GroupDao(configuration, rxClient);
	// }

	// @Provides
	// @Singleton
	// public RoleDao roleDao(Configuration configuration, SqlClient rxClient) {
	// return new RoleDao(configuration, rxClient);
	// }

	// @Provides
	// @Singleton
	// public ContentDao contentDao(Configuration configuration, SqlClient rxClient) {
	// return new ContentDao(configuration, rxClient);
	// }

	// @Provides
	// @Singleton
	// public NamespaceDao namespaceDao(Configuration configuration, SqlClient rxClient) {
	// return new NamespaceDao(configuration, rxClient);
	// }

	// @Provides
	// @Singleton
	// public TagDao tagDao(Configuration configuration, SqlClient rxClient) {
	// return new TagDao(configuration, rxClient);
	// }

	// @Provides
	// @Singleton
	// public AssetDao assetDao(Configuration configuration, SqlClient rxClient) {
	// return new AssetDao(configuration, rxClient);
	// }

	@Provides
	@Singleton
	public AssetBinaryDao assetBinaryDao(Configuration configuration, SqlClient rxClient) {
		return new AssetBinaryDao(configuration, rxClient);
	}

	// @Provides
	// @Singleton
	// public FieldDao fieldDao(Configuration configuration, SqlClient rxClient) {
	// return new FieldDao(configuration, rxClient);
	// }

	// @Provides
	// @Singleton
	// public TagNamespaceDao tagNamespaceDao(Configuration configuration, SqlClient rxClient) {
	// return new TagNamespaceDao(configuration, rxClient);
	// }

	@Provides
	@Singleton
	public TagContentDao tagContentDao(Configuration configuration, SqlClient rxClient) {
		return new TagContentDao(configuration, rxClient);
	}

	@Provides
	@Singleton
	public TagAssetDao tagAssetDao(Configuration configuration, SqlClient rxClient) {
		return new TagAssetDao(configuration, rxClient);
	}

	// @Provides
	// @Singleton
	// public UserTokenDao userTokenDao(Configuration configuration, SqlClient rxClient) {
	// return new UserTokenDao(configuration, rxClient);
	// }

	// @Provides
	// @Singleton
	// public WebhookDao webhookDao(Configuration configuration, SqlClient rxClient) {
	// return new WebhookDao(configuration, rxClient);
	// }
	//
	// @Provides
	// @Singleton
	// public ExtensionDao extensionDao(Configuration configuration, SqlClient rxClient) {
	// return new ExtensionDao(configuration, rxClient);
	// }

	@Provides
	@Singleton
	public ContentUserMetaDao contentUserMetaDao(Configuration configuration, SqlClient rxClient) {
		return new ContentUserMetaDao(configuration, rxClient);
	}

	@Provides
	@Singleton
	public AssetTimelineDao assetTimelineDao(Configuration configuration, SqlClient rxClient) {
		return new AssetTimelineDao(configuration, rxClient);
	}

	@Provides
	@Singleton
	public FieldReferenceDao fieldReferenceDao(Configuration configuration, SqlClient rxClient) {
		return new FieldReferenceDao(configuration, rxClient);
	}

	@Provides
	@Singleton
	public FieldAssetDao fieldAssetDao(Configuration configuration, SqlClient rxClient) {
		return new FieldAssetDao(configuration, rxClient);
	}

	@Provides
	@Singleton
	public LanguageDao languageDao(Configuration configuration, SqlClient rxClient) {
		return new LanguageDao(configuration, rxClient);
	}

	// @Provides
	// @Singleton
	// public ModelDao modelDao(Configuration configuration, SqlClient rxClient) {
	// return new ModelDao(configuration, rxClient);
	// }

	@Provides
	@Singleton
	public ModelVersionDao modelVersionDao(Configuration configuration, SqlClient rxClient) {
		return new ModelVersionDao(configuration, rxClient);
	}

	@Provides
	@Singleton
	public RolePermissionDao rolePermissionDao(Configuration configuration, SqlClient rxClient) {
		return new RolePermissionDao(configuration, rxClient);
	}

}
