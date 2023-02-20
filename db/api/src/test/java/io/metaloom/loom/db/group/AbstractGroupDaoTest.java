package io.metaloom.loom.db.group;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.metaloom.loom.db.model.group.LoomGroup;
import io.metaloom.loom.db.model.group.LoomGroupDao;

public abstract class AbstractGroupDaoTest {

	abstract public LoomGroupDao getDao();

	@After
	@Before
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
		assertNull("The group should be deleted.", dao.loadGroup(group.getUuid()));
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
