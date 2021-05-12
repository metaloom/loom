package io.metaloom.loom.db.namespace;

import io.metaloom.loom.test.dagger.DaggerLoomFsTestComponent;
import io.metaloom.loom.test.dagger.LoomFsTestComponent;

public class FsNamespaceDaoTest extends AbstractNamespaceDaoTest {

	public LoomNamespaceDao getDao() {
		LoomFsTestComponent loomTest = DaggerLoomFsTestComponent.create();
		return loomTest.daos().getNamespaceDao();
	}

}
