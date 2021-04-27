package io.metaloom.loom.db.group;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractGroupsDaoTest {

	abstract public GroupsDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		GroupsDao dao = getDao();

		// Create group
		Group group = dao.createGroup();
		group.setName("Guests");
		assertNotNull(group.getUuid());
		assertEquals("Guests", group.getName());
	}

	@Test
	public void testDelete() {
		GroupsDao dao = getDao();

		// Create group
		Group group = dao.createGroup();
		group.setName("Guests");

		// Now assert deletion
		dao.deleteGroup(group);
		assertNull(dao.loadGroup(group.getUuid()));
	}

	@Test
	public void testUpdate() {
		GroupsDao dao = getDao();

		// Create and store
		Group group = dao.createGroup();
		group.setName("Guests");
		dao.storeGroup(group);

		// Now update
		group.setName("Guests2");
		dao.updateGroup(group);

		// Load and assert update was persisted
		Group updatedGroup = dao.loadGroup(group.getUuid());
		assertEquals("Guests2", updatedGroup.getName());

	}

	@Test
	public void testLoad() {
		GroupsDao dao = getDao();

		// Create and store group
		Group group = dao.createGroup();
		group.setName("Guests");
		dao.storeGroup(group);

		// Now load again
		assertNotNull(dao.loadGroup(group.getUuid()));
	}
}