package io.metaloom.loom.db.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;

public abstract class AbstractUserDaoTest {

	abstract public LoomUserDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		LoomUserDao dao = getDao();

		// Create user
		LoomUser user = dao.createUser("joedoe");
		assertNotNull(user.getUuid());
		assertEquals("joedoe", user.getUsername());

	}

	@Test
	public void testDelete() {
		LoomUserDao dao = getDao();

		// Create user
		LoomUser user = dao.createUser("joeddoe");

		// Now assert deletion
		dao.deleteUser(user);
		assertNull(dao.loadUser(user.getUuid()), "The returned maybe should be empty.");
	}

	@Test
	public void testUpdate() {
		LoomUserDao dao = getDao();

		// Create and store
		LoomUser user = dao.createUser("joedoe");

		// Now update
		user.setUsername("joedoe2");
		dao.updateUser(user);

		// Load and assert update was persisted
		LoomUser updatedUser = dao.loadUser(user.getUuid());
		assertEquals("joedoe2", updatedUser.getUsername());

	}

	@Test
	public void testLoad() {
		LoomUserDao dao = getDao();

		// Create and store user
		LoomUser user = dao.createUser("joedoe");

		// Now load again
		assertNotNull(dao.loadUser(user.getUuid()));
	}
}
