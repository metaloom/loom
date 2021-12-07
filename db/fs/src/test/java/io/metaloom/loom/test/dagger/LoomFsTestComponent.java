package io.metaloom.loom.test.dagger;

import javax.inject.Singleton;

import dagger.Component;
import io.metaloom.loom.common.dagger.VertxModule;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.dagger.DBBindModule;
import io.metaloom.loom.db.fs.dagger.FsDaoBindModule;
import io.metaloom.loom.db.model.user.UserDao;

@Singleton
@Component(modules = { VertxModule.class, DBBindModule.class, FsDaoBindModule.class })
public interface LoomFsTestComponent {

	LoomDaoCollection daos();

	UserDao usersDao();

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
		LoomFsTestComponent build();
	}
}
