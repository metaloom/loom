package io.metaloom.loom.db.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Maybe;

public abstract class AbstractAssetDaoTest {

	abstract public LoomAssetDao getDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		LoomAssetDao dao = getDao();

		// Create asset
		LoomAsset asset = dao.createAsset().blockingGet();
		asset.setFilename("blume.jpg");
		assertNotNull(asset.getUuid());
		assertEquals("blume.jpg", asset.getFilename());
	}

	@Test
	public void testDelete() {
		LoomAssetDao dao = getDao();

		// Create asset
		LoomAsset asset = dao.createAsset().blockingGet();
		asset.setFilename("blume.jpg");

		// Now assert deletion
		dao.deleteAsset(asset);
		assertTrue("The asset should be deleted", dao.loadAsset(asset.getUuid()).isEmpty().blockingGet());
	}

	@Test
	public void testUpdate() {
		LoomAssetDao dao = getDao();

		// Create and store
		LoomAsset asset = dao.createAsset().blockingGet();
		asset.setFilename("blume.jpg");

		// Now update
		asset.setFilename("blume2.jpg");
		dao.updateAsset(asset);

		// Load and assert update was persisted
		Maybe<? extends LoomAsset> updatedAsset = dao.loadAsset(asset.getUuid());
		assertEquals("blume2.jpg", updatedAsset.blockingGet().getFilename());
	}

	@Test
	public void testLoad() {
		LoomAssetDao dao = getDao();

		// Create and store asset
		LoomAsset asset = dao.createAsset().blockingGet();
		asset.setFilename("blume.jpg");

		// Now load again
		assertNotNull(dao.loadAsset(asset.getUuid()));
	}
}
