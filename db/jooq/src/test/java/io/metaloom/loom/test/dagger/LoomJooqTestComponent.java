package io.metaloom.loom.test.dagger;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import io.metaloom.loom.common.LoomBaseComponent;
import io.metaloom.loom.common.dagger.LoomModule;
import io.metaloom.loom.common.dagger.VertxModule;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.dagger.DBBindModule;
import io.metaloom.loom.db.jooq.dagger.JooqLoomDaoBindModule;
import io.metaloom.loom.db.jooq.dagger.JooqNativeDaoModule;
import io.metaloom.loom.options.LoomOptions;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
@Component(modules = { VertxModule.class, LoomModule.class, DBBindModule.class, JooqLoomDaoBindModule.class, JooqNativeDaoModule.class })
public interface LoomJooqTestComponent extends LoomBaseComponent {

	LoomDaoCollection daos();

	SqlClient sqlClient();

	
	/**
	 * Builder for the main dagger component. It allows injection of options and the mesh instance which will be created by the {@link MeshFactory} outside of
	 * dagger.
	 */
	@Component.Builder
	interface Builder {

		/**
		 * Inject the options.
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
		LoomJooqTestComponent build();
	}
	
}
