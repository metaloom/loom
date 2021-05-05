package io.metaloom.loom.db.role;

import io.metaloom.loom.test.dagger.DaggerLoomTestComponent;
import io.metaloom.loom.test.dagger.LoomTestComponent;

public class FsRolesDaoTest extends AbstractRolesDaoTest {

	public RolesDao getDao() {
		LoomTestComponent loomTest = DaggerLoomTestComponent.create();
		return new FsRolesDaoImpl(loomTest.daos());
	}

}
