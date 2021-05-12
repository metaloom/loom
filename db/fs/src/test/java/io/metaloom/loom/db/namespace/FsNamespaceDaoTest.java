package io.metaloom.loom.db.namespace;

import io.metaloom.loom.test.dagger.DaggerLoomTestComponent;
import io.metaloom.loom.test.dagger.LoomTestComponent;

public class FsNamespaceDaoTest extends AbstractNamespaceDaoTest {

	public LoomNamespaceDao getDao() {
		LoomTestComponent loomTest = DaggerLoomTestComponent.create();
		return loomTest.daos().getNamespaceDao();
	}

}
