package io.metaloom.loom.db.jooq.dao.asset;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqAsset;
import io.metaloom.loom.db.model.asset.AssetLocation;
import io.metaloom.loom.db.model.asset.AssetLocationDao;

@Singleton
public class AssetLocationDaoImpl extends AbstractJooqDao<AssetLocation> implements AssetLocationDao {

	@Inject
	public AssetLocationDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqAsset.ASSET;
	}

	@Override
	protected Class<? extends AssetLocation> getPojoClass() {
		return AssetLocationImpl.class;
	}

	@Override
	public AssetLocation createAssetLocation(String filename, UUID assetUuid, UUID creatorUuid, UUID libraryUuid) {
		Objects.requireNonNull(creatorUuid, "Creator uuid must not be null");
		Objects.requireNonNull(libraryUuid, "Library uuid must not be null");
		Objects.requireNonNull(assetUuid, "Binary uuid must not be null");
		AssetLocation asset = new AssetLocationImpl();
		asset.setPath(filename);
		OffsetDateTime now = OffsetDateTime.now();
		asset.setCreated(now);
		asset.setEdited(now);
		asset.setCreatorUuid(creatorUuid);
		asset.setAssetUuid(assetUuid);
		return asset;
	}

	// @Override
	// public Completable deleteAsset(LoomAsset asset) {
	// Objects.requireNonNull(asset, "Asset must not be null");
	// return deleteById(asset.getUuid()).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomAsset> createAsset() {
	// Asset asset = new Asset();
	// insert(asset);
	// return insertReturningPrimary(asset).map(pk -> new LoomAssetImpl(asset.setUuid(pk)));
	// }
	//
	// @Override
	// public Completable updateAsset(LoomAsset asset) {
	// Objects.requireNonNull(asset, "Asset must not be null");
	// Asset jooqAsset = unwrap(asset);
	// return update(jooqAsset).ignoreElement();
	// }



}
