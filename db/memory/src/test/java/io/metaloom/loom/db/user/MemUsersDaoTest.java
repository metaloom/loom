package io.metaloom.loom.db.user;

public class MemUsersDaoTest extends AbstractUserDaoTest {

	private MemUsersDaoImpl dao = new MemUsersDaoImpl();

	@Override
	public LoomUserDao getDao() {
		return dao;
	}

}
