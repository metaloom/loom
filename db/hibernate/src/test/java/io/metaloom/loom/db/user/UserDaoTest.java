package io.metaloom.loom.db.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;

import io.metaloom.loom.db.AbstractDaoTest;
import io.metaloom.loom.db.hib.dao.impl.UserDaoImpl;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.UserDao;
import io.vertx.core.json.JsonObject;

public class UserDaoTest extends AbstractDaoTest {

	@Test
	public void testCreateUser() {
		System.out.println(UUID.randomUUID());
		UserDao dao = new UserDaoImpl(emf);
		LoomUser user = dao.createUser("dummy", u -> {
			JsonObject json = new JsonObject();
			json.put("test", "value");
			u.setMeta(json);
		}).blockingGet();
		assertNotNull("The user was not correctly created", user);
		assertEquals("dummy", user.getUsername());
		assertEquals("value", user.getMeta().getString("test"));

		LoomUser user2 = dao.loadUser(user.getUuid()).blockingGet();
		assertNotNull("The user was not correctly created", user2);
		assertEquals("dummy", user2.getUsername());
		assertEquals("value", user2.getMeta().getString("test"));
	}
}
