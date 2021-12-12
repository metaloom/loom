package io.metaloom.loom.db.jooq.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;

import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.reactivex.rxjava3.core.Observable;

public class LoomUserDaoTest extends AbstractJooqTest {

	@Test
	public void testBasics() {
		LoomUserDao userDao = userDao();
		LoomUser createdUser = userDao.createUser("dummy").blockingGet();

		Observable<LoomUser> obs = userDao.findAll();

		LoomUser loadedUser = userDao.loadUser(createdUser.getUuid()).blockingGet();
		assertNotNull(loadedUser);
		obs.subscribe(u -> {
			System.out.println("User: " + u.getUsername() + " " + u.getUuid());
		}, err -> {
			err.printStackTrace();
		});

		GroupDao groupDao = groupDao();
		Group group = groupDao.createGroup("test").blockingGet();
		assertNotNull(group);

		groupDao.addUserToGroup(group, loadedUser).blockingAwait();

		Group loadedGroup = groupDao.loadGroup(group.getUuid()).blockingGet();

	}

}
