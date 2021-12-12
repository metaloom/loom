package io.metaloom.loom.db.role;

import io.metaloom.loom.db.fs.dao.role.FsRoleDaoImpl;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.test.dagger.DaggerLoomFsTestComponent;
import io.metaloom.loom.test.dagger.LoomFsTestComponent;

public class FsRoleDaoTest extends AbstractRoleDaoTest {

	public RoleDao getDao() {
		LoomFsTestComponent loomTest = DaggerLoomFsTestComponent.create();
		return new FsRoleDaoImpl(loomTest.daos(), null);
	}

}
