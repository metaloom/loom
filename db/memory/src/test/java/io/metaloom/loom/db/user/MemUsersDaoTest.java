package io.metaloom.loom.db.user;

public class MemUsersDaoTest extends AbstractUsersDaoTest {

	private MemUsersDaoImpl dao = new MemUsersDaoImpl();

	@Override
	public UserDao getDao() {
		return dao;
	}

}
