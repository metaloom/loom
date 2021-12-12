package io.metaloom.loom.db.user;

import io.metaloom.loom.db.fs.dao.user.FsUserDaoImpl;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.test.dagger.DaggerLoomFsTestComponent;
import io.metaloom.loom.test.dagger.LoomFsTestComponent;

public class FsUserDaoTest extends AbstractUserDaoTest {

	public LoomUserDao getDao() {
		LoomFsTestComponent loomTest = DaggerLoomFsTestComponent.create();
		return new FsUserDaoImpl(loomTest.daos(), null);
	}

}
