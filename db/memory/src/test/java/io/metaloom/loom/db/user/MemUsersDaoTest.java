package io.metaloom.loom.db.user;

import io.metaloom.loom.db.model.user.LoomUserDao;

public class MemUsersDaoTest extends AbstractUserDaoTest {

	private MemUsersDaoImpl dao = new MemUsersDaoImpl();

	@Override
	public LoomUserDao getDao() {
		return dao;
	}

}
