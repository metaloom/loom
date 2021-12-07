package io.metaloom.loom.core.dagger;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import io.metaloom.loom.common.dagger.LoomModule;
import io.metaloom.loom.common.dagger.VertxModule;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.dagger.DBBindModule;
import io.metaloom.loom.db.hib.dagger.HibernateLoomDaoBindModule;
import io.metaloom.loom.db.hib.dagger.HibernateModule;
import io.metaloom.loom.options.LoomOptions;

/**
 * Central dagger loom component.
 */
@Singleton
@Component(modules = { VertxModule.class, LoomModule.class, DBBindModule.class, HibernateLoomDaoBindModule.class, HibernateModule.class })
public interface LoomCoreComponent {

	LoomDaoCollection daos();

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
		 * Inject loom instance.
		 * 
		 * @param loom
		 * @return
		 */
//		Builder loom(Loom loom);

		/**
		 * Build the component.
		 * 
		 * @return
		 */
		LoomCoreComponent build();

	}
}
