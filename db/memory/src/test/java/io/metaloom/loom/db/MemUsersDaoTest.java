package io.metaloom.loom.db;

import io.metaloom.loom.db.user.AbstractUsersDaoTest;
import io.metaloom.loom.db.user.MemUsersDaoImpl;
import io.metaloom.loom.db.user.UsersDao;

public class MemUsersDaoTest extends AbstractUsersDaoTest {

	@Override
	public UsersDao createDao() {
		return new MemUsersDaoImpl();
	}

}
