package io.metaloom.loom.db.asset;

public class FsAssetsDaoTest extends AbstractAssetsDaoTest {

	public LoomAssetDao getDao() {
		return new FsAssetDaoImpl(null, null);
	}

}
