package io.metaloom.loom.db.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import io.metaloom.loom.db.AbstractDaoTest;
import io.metaloom.loom.db.hib.dao.impl.GroupDaoImpl;
import io.metaloom.loom.db.hib.dao.impl.UserDaoImpl;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.group.impl.GroupImpl;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.UserDao;
import io.reactivex.rxjava3.annotations.NonNull;
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
		assertEquals("value", user.getMeta().getString("test"));
		System.out.println("User UUID: " + user.getUuid());

		Group group = groupDao.createGroup("group", g -> {
			JsonObject json = new JsonObject();
			json.put("test", "value");
			g.setMeta(json);
		}).blockingGet();
		assertEquals("value", group.getMeta().getString("test"));

		GroupImpl g = ((GroupImpl) group);
		g.addUser(user);
		Group updatedGroup = groupDao.updateGroup(group).blockingGet();
		assertEquals("value", updatedGroup.getMeta().getString("test"));

		List<@NonNull LoomUser> foundUsers = groupDao.loadUsers(group).toList().blockingGet();
		assertEquals(1, foundUsers.size());
		assertEquals(user.getUuid(), foundUsers.get(0).getUuid());
		System.out.println("Done");
	}
}
