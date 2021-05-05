package io.metaloom.loom.db.asset;

public class FsAssetsDaoTest extends AbstractAssetsDaoTest {

	public AssetsDao getDao() {
		return new FsAssetsDaoImpl(null);
	}

}
