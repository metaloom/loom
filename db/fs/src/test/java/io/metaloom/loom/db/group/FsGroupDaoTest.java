package io.metaloom.loom.db.group;

import io.metaloom.loom.test.dagger.DaggerLoomTestComponent;
import io.metaloom.loom.test.dagger.LoomTestComponent;

public class FsGroupDaoTest extends AbstractGroupDaoTest {

	public LoomGroupDao getDao() {
		LoomTestComponent loomTest = DaggerLoomTestComponent.create();
		return new FsGroupDaoImpl(loomTest.daos(), null);
	}

}
