package io.metaloom.loom.db.namespace;

import io.metaloom.loom.test.dagger.DaggerLoomJooqTestComponent;
import io.metaloom.loom.test.dagger.LoomJooqTestComponent;

public class JooqNamespaceDaoTest extends AbstractNamespaceDaoTest {

	public LoomNamespaceDao getDao() {
		LoomJooqTestComponent loomTest = DaggerLoomJooqTestComponent.builder().build();
		return loomTest.daos().getNamespaceDao();
	}

}
