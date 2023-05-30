package io.metaloom.loom.db.jooq.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.metaloom.loom.db.CRUDDaoTestcases;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.utils.hash.SHA512Sum;

public class AssetDaoTest extends AbstractJooqTest implements CRUDDaoTestcases<AssetDao, Asset> {

	@Override
	public Asset createElement(User user, int i) {
		return assetDao().createAsset(user.getUuid(), SHA512Sum.fromString(SHA256SUM), IMAGE_MIMETYPE, DUMMY_IMAGE_FILENAME, DUMMY_IMAGE_ORIGIN, 42L);
	}

	@Override
	public AssetDao getDao() {
		return assetDao();
	}

	@Override
	public void updateElement(Asset element) {
		element.setAudioFingerprint("new fingerprint");
	}

	@Override
	public void assertUpdate(Asset updatedAsset) {
		assertEquals("new fingerprint", updatedAsset.getAudioFingerprint());
	}

}
