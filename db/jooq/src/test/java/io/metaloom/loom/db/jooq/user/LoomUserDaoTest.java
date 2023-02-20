package io.metaloom.loom.db.jooq.user;

import static org.junit.Assert.assertNotNull;

import java.util.stream.Stream;

import org.junit.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.group.LoomGroup;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;

public class LoomUserDaoTest extends AbstractJooqTest {

	@Test
	public void testBasics() {
		LoomUserDao userDao = userDao();
		LoomUser createdUser = userDao.createUser("dummy");

		Stream<LoomUser> obs = userDao.findAll();

		LoomUser loadedUser = userDao.loadUser(createdUser.getUuid());
		assertNotNull(loadedUser);
		obs.forEach(u -> {
			System.out.println("User: " + u.getUsername() + " " + u.getUuid());
		});

		LoomGroupDao groupDao = groupDao();
		LoomGroup group = groupDao.createGroup("test");
		assertNotNull(group);

		groupDao.addUserToGroup(group, loadedUser);

		LoomGroup loadedGroup = groupDao.loadGroup(group.getUuid());

	}

}
