package io.metaloom.loom.db.namespace;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.namespace.NamespaceDao;

public abstract class AbstractNamespaceDaoTest {

	abstract public NamespaceDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		NamespaceDao dao = getDao();

		// Create namespace
		Namespace namespace = dao.createNamespace("Dummy");
		assertNotNull(namespace.getUuid());
		assertEquals("Dummy", namespace.getName());
	}

	@Test
	public void testDelete() {
		NamespaceDao dao = getDao();

		// Create namespace
		Namespace namespace = dao.createNamespace("Dummy");
		assertNotNull(namespace);

		// Now assert deletion
		dao.deleteNamespace(namespace.getUuid());
		assertNull(dao.loadNamespace(namespace.getUuid()), "The namespace should be deleted.");
	}

	@Test
	public void testUpdate() {
		NamespaceDao dao = getDao();

		// Create and store
		Namespace namespace = dao.createNamespace("Dummy");

		// Now update
		namespace.setName("Dummy2");
		dao.updateNamespace(namespace);

		// Load and assert update was persisted
		Namespace updatedNamespace = dao.loadNamespace(namespace.getUuid());
		assertEquals("Dummy2", updatedNamespace.getName());

	}

	@Test
	public void testLoad() {
		NamespaceDao dao = getDao();

		// Create and store namespace
		Namespace namespace = dao.createNamespace("Dummy");

		// Now load again
		assertNotNull(dao.loadNamespace(namespace.getUuid()));
	}
}
