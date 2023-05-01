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
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.model.collection.CollectionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.r2dbc.spi.ConnectionFactory;

@Singleton
@Component(modules = { JooqModule.class, FlywayModule.class, JooqLoomDaoBindModule.class, JooqNativeDaoModule.class, VertxModule.class })
public interface TestComponent {

	Flyway flyway();

	DataSource dataSource();

	DSLContext context();

	ConnectionFactory r2dbcConnectionFactory();

	UserDao userDao();

	AssetDao assetDao();

	GroupDao groupDao();

	RoleDao roleDao();

	PermissionDao permissionDao();

	CollectionDao collectionDao();

	LibraryDao libraryDao();

	LibraryDao namespaceDao();

	BinaryDao binaryDao();

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
