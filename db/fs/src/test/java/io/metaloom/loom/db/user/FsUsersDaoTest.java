package io.metaloom.loom.db.user;

import io.metaloom.loom.test.dagger.DaggerLoomTestComponent;
import io.metaloom.loom.test.dagger.LoomTestComponent;

public class FsUsersDaoTest extends AbstractUsersDaoTest {

	public UsersDao getDao() {
		LoomTestComponent loomTest = DaggerLoomTestComponent.create();
		return new FsUsersDaoImpl(loomTest.daos());
	}

}
