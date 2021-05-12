package io.metaloom.loom.db.user;

import io.metaloom.loom.test.dagger.DaggerLoomTestComponent;
import io.metaloom.loom.test.dagger.LoomTestComponent;

public class FsUserDaoTest extends AbstractUserDaoTest {

	public LoomUserDao getDao() {
		LoomTestComponent loomTest = DaggerLoomTestComponent.create();
		return new FsUserDaoImpl(loomTest.daos(), null);
	}

}
