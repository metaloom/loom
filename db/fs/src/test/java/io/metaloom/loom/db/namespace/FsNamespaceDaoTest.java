package io.metaloom.loom.db.namespace;

import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.test.dagger.DaggerLoomFsTestComponent;
import io.metaloom.loom.test.dagger.LoomFsTestComponent;

public class FsNamespaceDaoTest extends AbstractNamespaceDaoTest {

	public NamespaceDao getDao() {
		LoomFsTestComponent loomTest = DaggerLoomFsTestComponent.create();
		return loomTest.daos().getNamespaceDao();
	}

}
