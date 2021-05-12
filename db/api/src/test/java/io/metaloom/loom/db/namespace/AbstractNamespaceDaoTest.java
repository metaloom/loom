package io.metaloom.loom.db.namespace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Maybe;

public abstract class AbstractNamespaceDaoTest {

	abstract public LoomNamespaceDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		LoomNamespaceDao dao = getDao();

		// Create namespace
		LoomNamespace namespace = dao.createNamespace("Dummy").blockingGet();
		assertNotNull(namespace.getUuid());
		assertEquals("Dummy", namespace.getName());
	}

	@Test
	public void testDelete() {
		LoomNamespaceDao dao = getDao();

		// Create namespace
		LoomNamespace namespace = dao.createNamespace("Dummy").blockingGet();
		assertNotNull(namespace);

		// Now assert deletion
		dao.deleteNamespace(namespace.getUuid()).blockingAwait();
		assertTrue("The namespace should be deleted.", dao.loadNamespace(namespace.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		LoomNamespaceDao dao = getDao();

		// Create and store
		LoomNamespace namespace = dao.createNamespace("Dummy").blockingGet();

		// Now update
		namespace.setName("Dummy2");
		dao.updateNamespace(namespace).blockingAwait();

		// Load and assert update was persisted
		Maybe<? extends LoomNamespace> updatedNamespace = dao.loadNamespace(namespace.getUuid());
		assertEquals("Dummy2", updatedNamespace.blockingGet().getName());

	}

	@Test
	public void testLoad() {
		LoomNamespaceDao dao = getDao();

		// Create and store namespace
		LoomNamespace namespace = dao.createNamespace("Dummy").blockingGet();

		// Now load again
		assertNotNull(dao.loadNamespace(namespace.getUuid()).blockingGet());
	}
}
