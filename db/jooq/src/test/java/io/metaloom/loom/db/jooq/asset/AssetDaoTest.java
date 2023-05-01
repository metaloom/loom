package io.metaloom.loom.db.jooq.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.library.Library;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;

public class AssetDaoTest extends AbstractJooqTest {

	@Test
	public void testCreateAsset() {
		AssetDao assetDao = assetDao();

		AtomicReference<UUID> ref = new AtomicReference<>();
		User creator = createUser("joedoe");
		//Namespace namespace = createNamespace("Test");
		context.context().transaction(t -> {
			Asset asset = createAsset("blume.jpg", creator);
			assertNotNull(asset);
			ref.set(asset.getUuid());
			assertNotNull(asset.getUuid());
			assetDao.storeAsset(asset);
		});

		assertEquals(1, assetDao.count());
		assertNotNull(assetDao.loadAsset(ref.get()));
	}

	@Test
	public void testLoadPage() {
		User creator = createUser("joedoe");
		//Library library = createLibrary("Test");
		for (int i = 0; i < 1024; i++) {
			Asset asset = createAsset("blume_" + i + ".jpg", creator);
			assetDao().storeAsset(asset);
		}
		assertEquals(1024, assetDao().count());

		UUID uuid = null;
		long totalFound = 0;
		while (true) {
			Page<Asset> page = assetDao().loadAssets(uuid, 30);
			if (page.isEmpty()) {
				break;
			} else {
				uuid = page.lastUUID();
			}
			for (Asset asset : page) {
				System.out.println(asset);
				totalFound++;
			}
			System.out.println("--");
		}

		assertEquals(1024, totalFound);

	}

}
