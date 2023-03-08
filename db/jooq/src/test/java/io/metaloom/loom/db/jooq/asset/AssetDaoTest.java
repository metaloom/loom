package io.metaloom.loom.db.jooq.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.page.Page;

public class AssetDaoTest extends AbstractJooqTest {

	@Test
	public void testCreateAsset() {
		LoomAssetDao assetDao = assetDao();

		AtomicReference<UUID> ref = new AtomicReference<>();
		LoomUser creator = createUser("joedoe");
		LoomNamespace namespace = createNamespace("Test");
		context.context().transaction(t -> {
			LoomAsset asset = createAsset("blume.jpg", creator, namespace);
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
		LoomUser creator = createUser("joedoe");
		LoomNamespace namespace = createNamespace("Test");
		for (int i = 0; i < 1024; i++) {
			LoomAsset asset = createAsset("blume_" + i + ".jpg", creator, namespace);
			assetDao().storeAsset(asset);
		}
		assertEquals(1024, assetDao().count());

		UUID uuid = null;
		long totalFound = 0;
		while (true) {
			Page<LoomAsset> page = assetDao().loadAssets(uuid, 30);
			if (page.isEmpty()) {
				break;
			} else {
				uuid = page.lastUUID();
			}
			for (LoomAsset asset : page) {
				System.out.println(asset);
				totalFound++;
			}
			System.out.println("--");
		}

		assertEquals(1024, totalFound);

	}

}
