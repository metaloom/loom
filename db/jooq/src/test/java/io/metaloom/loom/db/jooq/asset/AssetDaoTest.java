package io.metaloom.loom.db.jooq.asset;

import static io.metaloom.loom.db.jooq.tables.Face.FACE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import org.jooq.DSLContext;
import org.jooq.JSONB;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.jooq.LoomPostgreSQLContainer;
import io.metaloom.loom.db.jooq.tables.Face;
import io.metaloom.loom.db.jooq.tables.records.FaceRecord;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.asset.LoomAssetBinary;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.user.LoomUser;

public class AssetDaoTest extends AbstractJooqTest {

	@Test
	public void testCreateAsset() {
		LoomAssetDao assetDao = assetDao();

		AtomicReference<UUID> ref = new AtomicReference<>();
		context.context().transaction(t -> {
			LoomAsset asset = createTestAsset();
			assertNotNull(asset);
			ref.set(asset.getUuid());
			assertNotNull(asset.getUuid());
			assetDao.storeAsset(asset);
		});

		assertEquals(1, assetDao.count());
		assertNotNull(assetDao.loadAsset(ref.get()));
	}

	private LoomAsset createTestAsset() {
		LoomUser creator = userDao().createUser("joedoe");
		LoomAssetBinary binary = binaryDao().createBinary(DUMMY_SHA512SUM, 42L);
		LoomNamespace namespace = namespaceDao().createNamespace("Test");
		binaryDao().storeBinary(binary);
		namespaceDao().storeNamespace(namespace);
		userDao().storeUser(creator);
		return assetDao().createAsset("blume.jpg", binary.getUuid(), creator, namespace.getUuid());
	}

	@Test
	public void testJooqFace() {
		LoomPostgreSQLContainer container = context.getContainer();
		try (Connection conn = DriverManager.getConnection(container.getJdbcUrl(), container.getUsername(), container.getPassword())) {
			DSLContext ctx = DSL.using(conn, SQLDialect.POSTGRES);

			// Clear DB
			ctx.delete(FACE).execute();

			ctx.transaction(t -> {

				for (int i = 0; i < 100; i++) {
					byte[] data = ("Test " + i).getBytes();
					assertEquals(1, ctx.insertInto(FACE)
						.columns(FACE.BLOB, FACE.SOURCE, FACE.FACE_NR)
						.values(data, "nix w" + i, 1)
						.execute());
				}

			});

			UUID newUuid = UUID.randomUUID();
			FaceRecord record = ctx.fetchOne(FACE, FACE.UUID.eq(newUuid));
			System.out.println(record);

			// record.store()
			Result<Record> faces = ctx.select()
				.from(Face.FACE)
				.fetch();

			faces.forEach(face -> {
				UUID uuid = face.getValue(FACE.UUID);
				JSONB meta = face.getValue(FACE.META);
				byte[] embedding = face.getValue(FACE.BLOB);

				System.out.println("Got " + uuid + " " + meta + " " + new String(embedding));
			});
			// For the sake of this tutorial, let's keep exception handling simple
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
