package io.metaloom.loom.db.asset;

public class FsAssetDaoTest extends AbstractAssetDaoTest {

	public LoomAssetDao getDao() {
		return new FsAssetDaoImpl(null, null);
	}

}
