package io.metaloom.loom.db.group;

import io.metaloom.loom.test.dagger.DaggerLoomFsTestComponent;
import io.metaloom.loom.test.dagger.LoomFsTestComponent;

public class FsGroupDaoTest extends AbstractGroupDaoTest {

	public LoomGroupDao getDao() {
		LoomFsTestComponent loomTest = DaggerLoomFsTestComponent.create();
		return new FsGroupDaoImpl(loomTest.daos(), null);
	}

}
