package io.metaloom.loom.db.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.metaloom.loom.db.AbstractDaoTest;
import io.metaloom.loom.db.hib.dao.impl.GroupDaoImpl;
import io.metaloom.loom.db.hib.dao.impl.UserDaoImpl;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.group.impl.GroupImpl;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.UserDao;
import io.vertx.core.json.JsonObject;

public class UserDaoTest extends AbstractDaoTest {

	@Test
	public void testCreateUser() {
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

	@Test
	public void testUserGroupDao() {
		UserDao userDao = new UserDaoImpl(emf);
		GroupDao groupDao = new GroupDaoImpl(emf);

		LoomUser user = userDao.createUser("dummy", u -> {
			JsonObject json = new JsonObject();
			json.put("test", "value");
			u.setMeta(json);
		}).blockingGet();

		Group group = groupDao.createGroup("group", g -> {
			JsonObject json = new JsonObject();
			json.put("test", "value");
			g.setMeta(json);
		}).blockingGet();

		GroupImpl g = ((GroupImpl) group);
		g.addUser(user);
		Group updatedGroup = groupDao.updateGroup(group).blockingGet();
		
		System.out.println("Done");
	}
}
