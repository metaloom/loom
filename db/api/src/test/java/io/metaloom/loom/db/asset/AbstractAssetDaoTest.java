package io.metaloom.loom.db.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;

public abstract class AbstractAssetDaoTest {

	abstract public AssetDao getDao();

	abstract public UserDao getUserDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}

	@Test
	public void testCreate() {
		// Create asset
		Asset asset = createTestAsset();
		assertNotNull(asset.getUuid());
		assertEquals("blume.jpg", asset.getPath());
		// assertNotNull(asset.getNamespaceUuid());
		// assertNotNull(asset.getBinaryUuid());
	}

	private Asset createTestAsset() {
		User creator = getUserDao().createUser("joedoe");
		UUID binaryUuid = UUID.randomUUID();
		UUID namespaceUuid = UUID.randomUUID();
		UUID creatorUuid = creator.getUuid();
		return getDao().createAsset("blume.jpg", binaryUuid, creatorUuid, namespaceUuid);
	}

	@Test
	public void testDelete() {
		AssetDao dao = getDao();

		// Create asset
		Asset asset = createTestAsset();

		// Now assert deletion
		dao.delete(asset);
		assertNull(dao.load(asset.getUuid()), "The asset should be deleted");
	}

	@Test
	public void testUpdate() {
		AssetDao dao = getDao();

		// Create and store
		Asset asset = createTestAsset();

		// Now update
		asset.setPath("blume2.jpg");
		dao.update(asset);

		// Load and assert update was persisted
		Asset updatedAsset = dao.load(asset.getUuid());
		assertEquals("blume2.jpg", updatedAsset.getPath());
	}

	@Test
	public void testLoad() {
		AssetDao dao = getDao();
		// Create and store asset
		Asset asset = createTestAsset();

		// Now load again
		assertNotNull(dao.load(asset.getUuid()));
	}
}
