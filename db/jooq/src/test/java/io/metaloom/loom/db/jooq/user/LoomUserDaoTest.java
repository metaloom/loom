package io.metaloom.loom.db.jooq.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;

public class LoomUserDaoTest extends AbstractJooqTest {

	@Test
	public void testBasics() {
		UserDao userDao = userDao();
		User createdUser = userDao.createUser("dummy");

		Stream<? extends User> obs = userDao.findAll();

		User loadedUser = userDao.load(createdUser.getUuid());
		assertNotNull(loadedUser);
		obs.forEach(u -> {
			System.out.println("User: " + u.getUsername() + " " + u.getUuid());
		});

		GroupDao groupDao = groupDao();
		Group group = groupDao.create("test");
		assertNotNull(group);

		groupDao.addUserToGroup(group, loadedUser);

		Group loadedGroup = groupDao.load(group.getUuid());

	}

}
