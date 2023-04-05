package io.metaloom.loom.db.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.group.LoomGroup;
import io.metaloom.loom.db.model.group.LoomGroupDao;

public abstract class AbstractGroupDaoTest {

	abstract public LoomGroupDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		LoomGroupDao dao = getDao();

		// Create group
		LoomGroup group = dao.createGroup("Guests");
		assertNotNull(group.getUuid());
		assertEquals("Guests", group.getName());
	}

	@Test
	public void testDelete() {
		LoomGroupDao dao = getDao();

		// Create group
		LoomGroup group = dao.createGroup("Guests");

		// Now assert deletion
		dao.deleteGroup(group.getUuid());
		assertNull(dao.loadGroup(group.getUuid()), "The group should be deleted.");
	}

	@Test
	public void testUpdate() {
		LoomGroupDao dao = getDao();

		// Create and store
		LoomGroup group = dao.createGroup("Guests");

		// Now update
		group.setName("Guests2");
		dao.updateGroup(group);

		// Load and assert update was persisted
		LoomGroup updatedGroup = dao.loadGroup(group.getUuid());
		assertEquals("Guests2", updatedGroup.getName());

	}

	@Test
	public void testLoad() {
		LoomGroupDao dao = getDao();

		// Create and store group
		LoomGroup group = dao.createGroup("Guests");

		// Now load again
		assertNotNull(dao.loadGroup(group.getUuid()));
	}
}
