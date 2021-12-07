package io.metaloom.loom.db.group;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.reactivex.rxjava3.core.Maybe;

public abstract class AbstractGroupDaoTest {

	abstract public GroupDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		GroupDao dao = getDao();

		// Create group
		Group group = dao.createGroup("Guests").blockingGet();
		assertNotNull(group.getUuid());
		assertEquals("Guests", group.getName());
	}

	@Test
	public void testDelete() {
		GroupDao dao = getDao();

		// Create group
		Group group = dao.createGroup("Guests").blockingGet();

		// Now assert deletion
		dao.deleteGroup(group.getUuid());
		assertTrue("The group should be deleted.", dao.loadGroup(group.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		GroupDao dao = getDao();

		// Create and store
		Group group = dao.createGroup("Guests").blockingGet();

		// Now update
		group.setName("Guests2");
		dao.updateGroup(group);

		// Load and assert update was persisted
		Maybe<? extends Group> updatedGroup = dao.loadGroup(group.getUuid());
		assertEquals("Guests2", updatedGroup.blockingGet().getName());

	}

	@Test
	public void testLoad() {
		GroupDao dao = getDao();

		// Create and store group
		Group group = dao.createGroup("Guests").blockingGet();

		// Now load again
		assertNotNull(dao.loadGroup(group.getUuid()));
	}
}
