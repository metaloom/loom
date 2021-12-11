package io.metaloom.loom.db.jooq.user;

import org.junit.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.reactivex.rxjava3.core.Observable;

public class LoomUserDaoTest extends AbstractJooqTest {

	@Test
	public void testBasics() {
		LoomUserDao userDao = userDao();
		userDao.createUser("dummy").blockingGet();

		Observable<LoomUser> obs = userDao.findAll();

		obs.subscribe(u -> {
			System.out.println(u.getUsername());
		}, err -> {
			err.printStackTrace();
		});
	}

}
