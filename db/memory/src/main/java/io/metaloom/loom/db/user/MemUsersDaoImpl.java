package io.metaloom.loom.db.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.mem.AbstractMemDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.page.Page;
import io.metaloom.utils.UUIDUtils;

public class MemUsersDaoImpl extends AbstractMemDao<User,UUID> implements UserDao {

	@Override
	public User loadUserByUsername(String username) {
		return storage.values().stream().filter(u -> u.getUsername().equals(username)).findFirst().get();
	}

	@Override
	public User createUser(String username) {
		User user = new MemUserImpl();
		user.setUuid(UUIDUtils.randomUUID());
		user.setUsername(username);
		return user;
	}

}
