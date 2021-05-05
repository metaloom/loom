package io.metaloom.loom.db.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Maybe;

public abstract class AbstractUsersDaoTest {

	abstract public UsersDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		UsersDao dao = getDao();

		// Create user
		User user = dao.createUser();
		user.setUsername("joedoe");
		assertNotNull(user.getUuid());
		assertEquals("joedoe", user.getUsername());

	}

	@Test
	public void testDelete() {
		UsersDao dao = getDao();

		// Create user
		User user = dao.createUser();
		user.setUsername("joedoe");

		// Now assert deletion
		dao.deleteUser(user);
		assertTrue("The returned maybe should be empty.", dao.loadUser(user.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		UsersDao dao = getDao();

		// Create and store
		User user = dao.createUser();
		user.setUsername("joedoe");
		dao.storeUser(user);

		// Now update
		user.setUsername("joedoe2");
		dao.updateUser(user);

		// Load and assert update was persisted
		Maybe<? extends User> updatedUser = dao.loadUser(user.getUuid());
		assertEquals("joedoe2", updatedUser.blockingGet().getUsername());

	}

	@Test
	public void testLoad() {
		UsersDao dao = getDao();

		// Create and store user
		User user = dao.createUser();
		user.setUsername("joedoe");
		dao.storeUser(user);

		// Now load again
		assertNotNull(dao.loadUser(user.getUuid()));
	}
}
