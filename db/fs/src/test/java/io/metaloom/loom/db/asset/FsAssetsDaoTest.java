package io.metaloom.loom.db.asset;

public class FsAssetsDaoTest extends AbstractAssetsDaoTest {

	public AssetDao getDao() {
		return new FsAssetDaoImpl(null);
	}

}
