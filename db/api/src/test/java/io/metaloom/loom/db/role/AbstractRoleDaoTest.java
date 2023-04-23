package io.metaloom.loom.db.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;

public abstract class AbstractRoleDaoTest {

	abstract public RoleDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		RoleDao dao = getDao();

		// Create role
		Role role = dao.createRole("Guests");
		assertNotNull(role.getUuid());
		assertEquals("Guests", role.getName());
	}

	@Test
	public void testDelete() {
		RoleDao dao = getDao();

		// Create role
		Role role = dao.createRole("Guests");

		// Now assert deletion
		dao.deleteRole(role.getUuid());
		assertNull( dao.loadRole(role.getUuid()), "No role should be found after deletion.");
	}

	@Test
	public void testUpdate() {
		RoleDao dao = getDao();

		// Create and store
		Role role = dao.createRole("Guests");

		// Now update
		role.setName("Guests2");
		dao.updateRole(role);

		// Load and assert update was persisted
		Role updatedRole = dao.loadRole(role.getUuid());
		assertEquals("Guests2", updatedRole.getName());
	}

	@Test
	public void testLoad() {
		RoleDao dao = getDao();

		// Create and store role
		Role role = dao.createRole("Guests");

		// Now load again
		assertNotNull(dao.loadRole(role.getUuid()));
	}
}
