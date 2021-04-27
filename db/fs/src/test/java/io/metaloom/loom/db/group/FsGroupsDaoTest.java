package io.metaloom.loom.db.group;

public class FsGroupsDaoTest extends AbstractGroupsDaoTest {

	public GroupsDao getDao() {
		return new FsGroupsDaoImpl();
	}

}
