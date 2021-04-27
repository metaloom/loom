package io.metaloom.loom.db.role;

public class FsRolesDaoTest extends AbstractRolesDaoTest {

	public RolesDao getDao() {
		return new FsRolesDaoImpl();
	}

}
