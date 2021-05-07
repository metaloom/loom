package io.metaloom.loom.db.jooq;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.group.Group;
import io.metaloom.loom.db.group.GroupDao;
import io.metaloom.loom.db.user.User;
import io.metaloom.loom.db.user.UserDao;
import io.metaloom.loom.test.dagger.DaggerLoomTestComponent;
import io.metaloom.loom.test.dagger.LoomTestComponent;
import io.reactivex.Observable;

public class BasicDaoTest {

	@Test
	public void testUserDao() {
		LoomTestComponent loomComponent = DaggerLoomTestComponent.create();
		User user = loomComponent.daos().getUserDao().createUser("test-" + System.currentTimeMillis()).blockingGet();
		assertNotNull(user.getUuid());
	}
	
	@Test
	public void testTransactions() {
		LoomTestComponent loomComponent = DaggerLoomTestComponent.create();
		loomComponent.daos().getGroupDao().testMultiOp();
	}

	@Test
	public void testGroupDao() {
		LoomTestComponent loomComponent = DaggerLoomTestComponent.create();
		DaoCollection daos = loomComponent.daos();
		GroupDao groupDao = daos.getGroupDao();
		UserDao userDao = daos.getUserDao();
		// SqlClient client = loomComponent.sqlClient();

		Group group = groupDao.loadGroup(UUID.fromString("6031fcd0-4a92-4d6d-ae43-f37c2f9def63")).blockingGet();
		for (int i = 0; i < 10; i++) {
			User user = userDao.createUser("Name-" + System.currentTimeMillis()).blockingGet();
			assertNotNull(user.getUuid());
			// Group group = groupDao.createGroup("Test").blockingGet();
			groupDao.addUser(group, user).blockingAwait();
		}

		// userDao.updateUser(user);
		// 4ccdfb6f-b2d4-4ffa-a9d4-5cac8b457b39

		Observable<User> result = groupDao.loadUsers(group);
		result.blockingForEach(e -> {
			System.out.println("found user: " + e.getUsername());
		});
	}
}
