package io.metaloom.loom.db.namespace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.reactivex.rxjava3.core.Maybe;

public abstract class AbstractNamespaceDaoTest {

	abstract public NamespaceDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		NamespaceDao dao = getDao();

		// Create namespace
		Namespace namespace = dao.createNamespace("Dummy").blockingGet();
		assertNotNull(namespace.getUuid());
		assertEquals("Dummy", namespace.getName());
	}

	@Test
	public void testDelete() {
		NamespaceDao dao = getDao();

		// Create namespace
		Namespace namespace = dao.createNamespace("Dummy").blockingGet();
		assertNotNull(namespace);

		// Now assert deletion
		dao.deleteNamespace(namespace.getUuid()).blockingAwait();
		assertTrue("The namespace should be deleted.", dao.loadNamespace(namespace.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		NamespaceDao dao = getDao();

		// Create and store
		Namespace namespace = dao.createNamespace("Dummy").blockingGet();

		// Now update
		namespace.setName("Dummy2");
		dao.updateNamespace(namespace).blockingAwait();

		// Load and assert update was persisted
		Maybe<? extends Namespace> updatedNamespace = dao.loadNamespace(namespace.getUuid());
		assertEquals("Dummy2", updatedNamespace.blockingGet().getName());

	}

	@Test
	public void testLoad() {
		NamespaceDao dao = getDao();

		// Create and store namespace
		Namespace namespace = dao.createNamespace("Dummy").blockingGet();

		// Now load again
		assertNotNull(dao.loadNamespace(namespace.getUuid()).blockingGet());
	}
}
