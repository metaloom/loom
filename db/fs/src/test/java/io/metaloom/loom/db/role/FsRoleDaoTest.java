package io.metaloom.loom.db.role;

import io.metaloom.loom.test.dagger.DaggerLoomTestComponent;
import io.metaloom.loom.test.dagger.LoomTestComponent;

public class FsRoleDaoTest extends AbstractRoleDaoTest {

	public LoomRoleDao getDao() {
		LoomTestComponent loomTest = DaggerLoomTestComponent.create();
		return new FsRoleDaoImpl(loomTest.daos(), null);
	}

}
