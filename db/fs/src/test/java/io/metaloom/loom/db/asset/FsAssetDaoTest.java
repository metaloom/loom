package io.metaloom.loom.db.asset;

import io.metaloom.loom.db.fs.dao.asset.FsAssetDaoImpl;
import io.metaloom.loom.db.model.asset.AssetDao;

public class FsAssetDaoTest extends AbstractAssetDaoTest {

	public AssetDao getDao() {
		return new FsAssetDaoImpl(null, null);
	}

}
