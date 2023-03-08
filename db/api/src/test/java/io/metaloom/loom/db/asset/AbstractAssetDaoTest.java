package io.metaloom.loom.db.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;

public abstract class AbstractAssetDaoTest {

	abstract public LoomAssetDao getDao();

	abstract public LoomUserDao getUserDao();

	@After
	@Before
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		// Create asset
		LoomAsset asset = createTestAsset();
		assertNotNull(asset.getUuid());
		assertEquals("blume.jpg", asset.getFilename());
//		assertNotNull(asset.getNamespaceUuid());
//		assertNotNull(asset.getBinaryUuid());
	}

	private LoomAsset createTestAsset() {
		LoomUser creator = getUserDao().createUser("joedoe");
		UUID binaryUuid = UUID.randomUUID();
		UUID namespaceUuid = UUID.randomUUID();
		return getDao().createAsset("blume.jpg", binaryUuid, creator, namespaceUuid);
	}

	@Test
	public void testDelete() {
		LoomAssetDao dao = getDao();

		// Create asset
		LoomAsset asset = createTestAsset();

		// Now assert deletion
		dao.deleteAsset(asset);
		assertNull("The asset should be deleted", dao.loadAsset(asset.getUuid()));
	}

	@Test
	public void testUpdate() {
		LoomAssetDao dao = getDao();

		// Create and store
		LoomAsset asset = createTestAsset();

		// Now update
		asset.setFilename("blume2.jpg");
		dao.updateAsset(asset);

		// Load and assert update was persisted
		LoomAsset updatedAsset = dao.loadAsset(asset.getUuid());
		assertEquals("blume2.jpg", updatedAsset.getFilename());
	}

	@Test
	public void testLoad() {
		LoomAssetDao dao = getDao();
		// Create and store asset
		LoomAsset asset = createTestAsset();

		// Now load again
		assertNotNull(dao.loadAsset(asset.getUuid()));
	}
}
