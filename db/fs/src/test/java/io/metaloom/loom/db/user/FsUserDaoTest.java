package io.metaloom.loom.db.user;

import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.test.dagger.DaggerLoomFsTestComponent;
import io.metaloom.loom.test.dagger.LoomFsTestComponent;

public class FsUserDaoTest extends AbstractUserDaoTest {

	public UserDao getDao() {
		LoomFsTestComponent loomTest = DaggerLoomFsTestComponent.create();
		return new FsUserDaoImpl(loomTest.daos(), null);
	}

}
