package io.metaloom.loom.db.user;

import io.metaloom.loom.db.model.user.UserDao;

public class MemUsersDaoTest extends AbstractUserDaoTest {

	private MemUsersDaoImpl dao = new MemUsersDaoImpl();

	@Override
	public UserDao getDao() {
		return dao;
	}

}
