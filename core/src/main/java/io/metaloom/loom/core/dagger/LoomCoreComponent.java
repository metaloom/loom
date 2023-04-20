package io.metaloom.loom.core.dagger;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.auth.jwt.JWTAuthModule;
import io.metaloom.loom.common.dagger.LoomModule;
import io.metaloom.loom.common.dagger.VertxModule;
import io.metaloom.loom.core.boot.BootstrapInitializer;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.dagger.DBBindModule;
import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.dagger.JooqLoomDaoBindModule;
import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.metaloom.loom.db.jooq.dagger.JooqNativeDaoModule;
import io.metaloom.loom.rest.dagger.RESTModule;

/**
 * Central dagger loom component.
 */
@Singleton
@Component(modules = { VertxModule.class,
	LoomModule.class,
	JWTAuthModule.class,
	AuthBindModule.class,
	FlywayModule.class,
	DBBindModule.class,
	JooqLoomDaoBindModule.class,
	JooqModule.class,
	JooqNativeDaoModule.class,
	RESTModule.class })
public interface LoomCoreComponent {

	LoomDaoCollection daos();

	BootstrapInitializer boot();

	@Component.Builder
	interface Builder {

		/**
		 * Inject configuration options.
		 * 
		 * @param options
		 * @return
		 */
		@BindsInstance
		Builder configuration(LoomOptions options);

		/**
		 * Build the component.
		 * 
		 * @return
		 */
		LoomCoreComponent build();

	}
}
