package io.metaloom.loom.db.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Maybe;

public abstract class AbstractUsersDaoTest {

	abstract public UserDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		UserDao dao = getDao();

		// Create user
		User user = dao.createUser("joedoe").blockingGet();
		assertNotNull(user.getUuid());
		assertEquals("joedoe", user.getUsername());

	}

	@Test
	public void testDelete() {
		UserDao dao = getDao();

		// Create user
		User user = dao.createUser("joeddoe").blockingGet();

		// Now assert deletion
		dao.deleteUser(user);
		assertTrue("The returned maybe should be empty.", dao.loadUser(user.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		UserDao dao = getDao();

		// Create and store
		User user = dao.createUser("joedoe").blockingGet();

		// Now update
		user.setUsername("joedoe2");
		dao.updateUser(user);

		// Load and assert update was persisted
		Maybe<? extends User> updatedUser = dao.loadUser(user.getUuid());
		assertEquals("joedoe2", updatedUser.blockingGet().getUsername());

	}

	@Test
	public void testLoad() {
		UserDao dao = getDao();

		// Create and store user
		User user = dao.createUser("joedoe").blockingGet();

		// Now load again
		assertNotNull(dao.loadUser(user.getUuid()));
	}
}
