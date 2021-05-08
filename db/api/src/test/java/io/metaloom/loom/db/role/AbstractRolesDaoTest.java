package io.metaloom.loom.db.role;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Maybe;

public abstract class AbstractRolesDaoTest {

	abstract public LoomRoleDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		LoomRoleDao dao = getDao();

		// Create role
		LoomRole role = dao.createRole("Guests").blockingGet();
		assertNotNull(role.getUuid());
		assertEquals("Guests", role.getName());
	}

	@Test
	public void testDelete() {
		LoomRoleDao dao = getDao();

		// Create role
		LoomRole role = dao.createRole("Guests").blockingGet();

		// Now assert deletion
		dao.deleteRole(role);
		assertTrue("No role should be found after deletion.", dao.loadRole(role.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		LoomRoleDao dao = getDao();

		// Create and store
		LoomRole role = dao.createRole("Guests").blockingGet();
		dao.storeRole(role);

		// Now update
		role.setName("Guests2");
		dao.updateRole(role);

		// Load and assert update was persisted
		Maybe<? extends LoomRole> updatedRole = dao.loadRole(role.getUuid());
		assertEquals("Guests2", updatedRole.blockingGet().getName());

	}

	@Test
	public void testLoad() {
		LoomRoleDao dao = getDao();

		// Create and store role
		LoomRole role = dao.createRole("Guests").blockingGet();

		dao.storeRole(role);

		// Now load again
		assertNotNull(dao.loadRole(role.getUuid()));
	}
}
