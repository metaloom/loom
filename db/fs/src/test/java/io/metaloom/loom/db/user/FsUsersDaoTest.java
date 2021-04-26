package io.metaloom.loom.db.user;

public class FsUsersDaoTest extends AbstractUsersDaoTest {

	public UsersDao createDao() {
		return new FsUsersDaoImpl();
	}
}
