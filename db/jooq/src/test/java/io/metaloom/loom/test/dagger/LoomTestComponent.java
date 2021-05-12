package io.metaloom.loom.test.dagger;

import javax.inject.Singleton;

import dagger.Component;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.dagger.DBBindModule;
import io.metaloom.loom.db.dagger.VertxModule;
import io.metaloom.loom.db.jooq.dagger.JooqLoomDaoBindModule;
import io.metaloom.loom.db.jooq.dagger.JooqNativeDaoModule;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
@Component(modules = { VertxModule.class, DBBindModule.class, JooqLoomDaoBindModule.class, JooqNativeDaoModule.class })
public interface LoomTestComponent {

	LoomDaoCollection daos();

	SqlClient sqlClient();

	/**
	 * Builder for the main dagger component. It allows injection of options and the mesh instance which will be created by the {@link MeshFactory} outside of
	 * dagger.
	 */
	interface Builder {

		/**
		 * Build the component.
		 * 
		 * @return
		 */
		LoomTestComponent build();
	}
}
