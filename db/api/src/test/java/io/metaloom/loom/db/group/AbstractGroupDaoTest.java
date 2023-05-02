package io.metaloom.loom.db.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;

public abstract class AbstractGroupDaoTest {

	abstract public GroupDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		GroupDao dao = getDao();

		// Create group
		Group group = dao.create("Guests");
		assertNotNull(group.getUuid());
		assertEquals("Guests", group.getName());
	}

	@Test
	public void testDelete() {
		GroupDao dao = getDao();

		// Create group
		Group group = dao.create("Guests");

		// Now assert deletion
		dao.delete(group.getUuid());
		assertNull(dao.load(group.getUuid()), "The group should be deleted.");
	}

	@Test
	public void testUpdate() {
		GroupDao dao = getDao();

		// Create and store
		Group group = dao.create("Guests");

		// Now update
		group.setName("Guests2");
		dao.update(group);

		// Load and assert update was persisted
		Group updatedGroup = dao.load(group.getUuid());
		assertEquals("Guests2", updatedGroup.getName());

	}

	@Test
	public void testLoad() {
		GroupDao dao = getDao();

		// Create and store group
		Group group = dao.create("Guests");

		// Now load again
		assertNotNull(dao.load(group.getUuid()));
	}
}
