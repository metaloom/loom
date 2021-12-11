package io.metaloom.loom.db.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.reactivex.rxjava3.core.Maybe;

public abstract class AbstractUserDaoTest {

	abstract public LoomUserDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		LoomUserDao dao = getDao();

		// Create user
		LoomUser user = dao.createUser("joedoe").blockingGet();
		assertNotNull(user.getUuid());
		assertEquals("joedoe", user.getUsername());

	}

	@Test
	public void testDelete() {
		LoomUserDao dao = getDao();

		// Create user
		LoomUser user = dao.createUser("joeddoe").blockingGet();

		// Now assert deletion
		dao.deleteUser(user);
		assertTrue("The returned maybe should be empty.", dao.loadUser(user.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		LoomUserDao dao = getDao();

		// Create and store
		LoomUser user = dao.createUser("joedoe").blockingGet();

		// Now update
		user.setUsername("joedoe2");
		dao.updateUser(user);

		// Load and assert update was persisted
		Maybe<? extends LoomUser> updatedUser = dao.loadUser(user.getUuid());
		assertEquals("joedoe2", updatedUser.blockingGet().getUsername());

	}

	@Test
	public void testLoad() {
		LoomUserDao dao = getDao();

		// Create and store user
		LoomUser user = dao.createUser("joedoe").blockingGet();

		// Now load again
		assertNotNull(dao.loadUser(user.getUuid()));
	}
}
