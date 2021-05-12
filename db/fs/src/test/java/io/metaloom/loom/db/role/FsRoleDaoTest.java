package io.metaloom.loom.db.role;

import io.metaloom.loom.test.dagger.DaggerLoomFsTestComponent;
import io.metaloom.loom.test.dagger.LoomFsTestComponent;

public class FsRoleDaoTest extends AbstractRoleDaoTest {

	public LoomRoleDao getDao() {
		LoomFsTestComponent loomTest = DaggerLoomFsTestComponent.create();
		return new FsRoleDaoImpl(loomTest.daos(), null);
	}

}
