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

	abstract public RoleDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		RoleDao dao = getDao();

		// Create role
		Role role = dao.createRole();
		role.setName("Guests");
		assertNotNull(role.getUuid());
		assertEquals("Guests", role.getName());
	}

	@Test
	public void testDelete() {
		RoleDao dao = getDao();

		// Create role
		Role role = dao.createRole();
		role.setName("Guests");

		// Now assert deletion
		dao.deleteRole(role);
		assertTrue("No role should be found after deletion.", dao.loadRole(role.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		RoleDao dao = getDao();

		// Create and store
		Role role = dao.createRole();
		role.setName("Guests");
		dao.storeRole(role);

		// Now update
		role.setName("Guests2");
		dao.updateRole(role);

		// Load and assert update was persisted
		Maybe<? extends Role> updatedRole = dao.loadRole(role.getUuid());
		assertEquals("Guests2", updatedRole.blockingGet().getName());

	}

	@Test
	public void testLoad() {
		RoleDao dao = getDao();

		// Create and store role
		Role role = dao.createRole();
		role.setName("Guests");
		dao.storeRole(role);

		// Now load again
		assertNotNull(dao.loadRole(role.getUuid()));
	}
}
