package io.metaloom.loom.db.jooq.test.dagger;

import javax.inject.Singleton;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import dagger.BindsInstance;
import dagger.Component;
import io.metaloom.loom.api.options.DatabaseOptions;
import io.metaloom.loom.common.dagger.VertxModule;
import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.metaloom.loom.db.jooq.dagger.JooqNativeDaoModule;
import io.metaloom.loom.db.jooq.dagger.JooqLoomDaoBindModule;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.r2dbc.spi.ConnectionFactory;

@Singleton
@Component(modules = { JooqModule.class, FlywayModule.class, JooqLoomDaoBindModule.class, JooqNativeDaoModule.class, VertxModule.class })
public interface TestComponent {

	Flyway flyway();

	DataSource dataSource();

	ConnectionFactory r2dbcConnectionFactory();

	LoomUserDao userDao();

	LoomGroupDao groupDao();

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