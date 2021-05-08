package io.metaloom.loom.db.group;

import io.metaloom.loom.test.dagger.DaggerLoomTestComponent;
import io.metaloom.loom.test.dagger.LoomTestComponent;

public class FsGroupsDaoTest extends AbstractGroupsDaoTest {

	public LoomGroupDao getDao() {
		LoomTestComponent loomTest = DaggerLoomTestComponent.create();
		return new FsGroupDaoImpl(loomTest.daos(), null);
	}

}
