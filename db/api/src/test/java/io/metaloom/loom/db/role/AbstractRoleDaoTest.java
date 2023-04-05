package io.metaloom.loom.db.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.role.LoomRole;
import io.metaloom.loom.db.model.role.LoomRoleDao;

public abstract class AbstractRoleDaoTest {

	abstract public LoomRoleDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		LoomRoleDao dao = getDao();

		// Create role
		LoomRole role = dao.createRole("Guests");
		assertNotNull(role.getUuid());
		assertEquals("Guests", role.getName());
	}

	@Test
	public void testDelete() {
		LoomRoleDao dao = getDao();

		// Create role
		LoomRole role = dao.createRole("Guests");

		// Now assert deletion
		dao.deleteRole(role.getUuid());
		assertNull( dao.loadRole(role.getUuid()), "No role should be found after deletion.");
	}

	@Test
	public void testUpdate() {
		LoomRoleDao dao = getDao();

		// Create and store
		LoomRole role = dao.createRole("Guests");

		// Now update
		role.setName("Guests2");
		dao.updateRole(role);

		// Load and assert update was persisted
		LoomRole updatedRole = dao.loadRole(role.getUuid());
		assertEquals("Guests2", updatedRole.getName());
	}

	@Test
	public void testLoad() {
		LoomRoleDao dao = getDao();

		// Create and store role
		LoomRole role = dao.createRole("Guests");

		// Now load again
		assertNotNull(dao.loadRole(role.getUuid()));
	}
}
