package io.metaloom.loom.db.namespace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;

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
		LoomNamespace namespace = dao.createNamespace("Dummy");
		assertNotNull(namespace.getUuid());
		assertEquals("Dummy", namespace.getName());
	}

	@Test
	public void testDelete() {
		LoomNamespaceDao dao = getDao();

		// Create namespace
		LoomNamespace namespace = dao.createNamespace("Dummy");
		assertNotNull(namespace);

		// Now assert deletion
		dao.deleteNamespace(namespace.getUuid());
		assertNull("The namespace should be deleted.", dao.loadNamespace(namespace.getUuid()));
	}

	@Test
	public void testUpdate() {
		LoomNamespaceDao dao = getDao();

		// Create and store
		LoomNamespace namespace = dao.createNamespace("Dummy");

		// Now update
		namespace.setName("Dummy2");
		dao.updateNamespace(namespace);

		// Load and assert update was persisted
		LoomNamespace updatedNamespace = dao.loadNamespace(namespace.getUuid());
		assertEquals("Dummy2", updatedNamespace.getName());

	}

	@Test
	public void testLoad() {
		LoomNamespaceDao dao = getDao();

		// Create and store namespace
		LoomNamespace namespace = dao.createNamespace("Dummy");

		// Now load again
		assertNotNull(dao.loadNamespace(namespace.getUuid()));
	}
}
