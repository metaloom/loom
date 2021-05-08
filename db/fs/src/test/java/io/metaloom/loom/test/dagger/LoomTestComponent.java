package io.metaloom.loom.test.dagger;

import javax.inject.Singleton;

import dagger.Component;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.dagger.VertxModule;
import io.metaloom.loom.db.fs.dagger.FsDaoBindModule;
import io.metaloom.loom.db.user.LoomUserDao;

@Singleton
@Component(modules = { VertxModule.class, FsDaoBindModule.class })
public interface LoomTestComponent {

	DaoCollection daos();

	LoomUserDao usersDao();

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
