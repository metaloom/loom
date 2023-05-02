package io.metaloom.loom.db.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;

public abstract class AbstractUserDaoTest {

	abstract public UserDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		UserDao dao = getDao();

		// Create user
		User user = dao.createUser("joedoe");
		assertNotNull(user.getUuid());
		assertEquals("joedoe", user.getUsername());

	}

	@Test
	public void testDelete() {
		UserDao dao = getDao();

		// Create user
		User user = dao.createUser("joeddoe");

		// Now assert deletion
		dao.delete(user);
		assertNull(dao.load(user.getUuid()), "The returned maybe should be empty.");
	}

	@Test
	public void testUpdate() {
		UserDao dao = getDao();

		// Create and store
		User user = dao.createUser("joedoe");

		// Now update
		user.setUsername("joedoe2");
		dao.update(user);

		// Load and assert update was persisted
		User updatedUser = dao.load(user.getUuid());
		assertEquals("joedoe2", updatedUser.getUsername());

	}

	@Test
	public void testLoad() {
		UserDao dao = getDao();

		// Create and store user
		User user = dao.createUser("joedoe");

		// Now load again
		assertNotNull(dao.load(user.getUuid()));
	}
}
