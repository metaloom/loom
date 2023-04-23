package io.metaloom.loom.db.jooq.test.dagger;

import javax.inject.Singleton;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.jooq.DSLContext;

import dagger.BindsInstance;
import dagger.Component;
import io.metaloom.loom.api.options.DatabaseOptions;
import io.metaloom.loom.common.dagger.VertxModule;
import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.dagger.JooqLoomDaoBindModule;
import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.metaloom.loom.db.jooq.dagger.JooqNativeDaoModule;
import io.metaloom.loom.db.model.asset.LoomAssetBinaryDao;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.model.perm.LoomPermissionDao;
import io.metaloom.loom.db.model.role.LoomRoleDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.r2dbc.spi.ConnectionFactory;

@Singleton
@Component(modules = { JooqModule.class, FlywayModule.class, JooqLoomDaoBindModule.class, JooqNativeDaoModule.class, VertxModule.class })
public interface TestComponent {

	Flyway flyway();

	DataSource dataSource();

	DSLContext context();

	ConnectionFactory r2dbcConnectionFactory();

	LoomUserDao userDao();

	LoomAssetDao assetDao();

	LoomGroupDao groupDao();

	LoomRoleDao roleDao();

	LoomPermissionDao permissionDao();

	LoomNamespaceDao namespaceDao();

	LoomAssetBinaryDao binaryDao();

	@Component.Builder
	interface Builder {

		@BindsInstance
		Builder configuration(DatabaseOptions options);

		/**
		 * Build the component.
		 * 
		 * @return
		 */
		TestComponent build();

	}

}
