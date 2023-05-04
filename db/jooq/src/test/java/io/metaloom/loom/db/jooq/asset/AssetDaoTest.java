package io.metaloom.loom.db.jooq.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.metaloom.loom.db.CRUDDaoTestcases;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.user.User;

public class AssetDaoTest extends AbstractJooqTest implements CRUDDaoTestcases<AssetDao, Asset> {

	@Override
	public Asset createElement(User user, int i) {
		return assetDao().createAsset("test_" + i + ".jpg", BINARY_UUID, ADMIN_UUID, LIBRARY_UUID);
	}

	@Override
	public AssetDao getDao() {
		return assetDao();
	}

	@Override
	public void updateElement(Asset element) {
		element.setPath("new path");
	}

	@Override
	public void assertUpdate(Asset updatedAsset) {
		assertEquals("new path", updatedAsset.getPath());
	}

}
