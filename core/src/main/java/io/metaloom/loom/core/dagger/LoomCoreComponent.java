package io.metaloom.loom.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import io.metaloom.Loom;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.dagger.DBBindModule;
import io.metaloom.loom.db.dagger.VertxModule;
import io.metaloom.loom.db.jooq.dagger.JooqLoomDaoBindModule;
import io.metaloom.loom.db.jooq.dagger.JooqNativeDaoModule;
import io.metaloom.loom.options.LoomOptions;

/**
 * Central dagger loom component.
 */
@Singleton
@Component(modules = { VertxModule.class, DBBindModule.class, JooqLoomDaoBindModule.class, JooqNativeDaoModule.class })
public interface LoomCoreComponent {

	LoomDaoCollection daos();

	interface Builder {

		/**
		 * Inject configuration options.
		 * 
		 * @param options
		 * @return
		 */
		Builder configuration(LoomOptions options);

		/**
		 * Inject loom instance.
		 * 
		 * @param loom
		 * @return
		 */
		Builder loom(Loom loom);

		/**
		 * Build the component.
		 * 
		 * @return
		 */
		LoomCoreComponent build();

	}
}
