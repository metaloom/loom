package io.metaloom.loom.test.dagger;

import javax.inject.Singleton;

import dagger.Component;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.dagger.DBBindModule;
import io.metaloom.loom.db.dagger.VertxModule;
import io.metaloom.loom.db.jooq.dagger.JooqDaoBindModule;
import io.metaloom.loom.db.jooq.dagger.JooqNativeDaoModule;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
@Component(modules = { VertxModule.class, DBBindModule.class, JooqDaoBindModule.class, JooqNativeDaoModule.class })
public interface LoomTestComponent {

	DaoCollection daos();

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
