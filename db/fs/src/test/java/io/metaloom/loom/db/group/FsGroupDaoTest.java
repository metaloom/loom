package io.metaloom.loom.db.group;

import io.metaloom.loom.db.fs.dao.group.GroupDaoImpl;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.test.dagger.DaggerLoomFsTestComponent;
import io.metaloom.loom.test.dagger.LoomFsTestComponent;

public class FsGroupDaoTest extends AbstractGroupDaoTest {

	public GroupDao getDao() {
		LoomFsTestComponent loomTest = DaggerLoomFsTestComponent.create();
		return new GroupDaoImpl(loomTest.daos(), null);
	}

}
