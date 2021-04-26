package io.metaloom.loom.db.user;

public class FsUsersDaoTest extends AbstractUsersDaoTest {

	public UsersDao getDao() {
		return new FsUsersDaoImpl();
	}

}
