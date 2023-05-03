package io.metaloom.loom.db.jooq.dao.asset;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqAsset;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.tag.Tag;

@Singleton
public class AssetDaoImpl extends AbstractJooqDao<Asset> implements AssetDao {

	@Inject
	public AssetDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqAsset.ASSET;
	}

	@Override
	protected Class<? extends Asset> getPojoClass() {
		return AssetImpl.class;
	}

	@Override
	public Asset createAsset(String filename, UUID binaryUuid, UUID creatorUuid, UUID libraryUuid) {
		Objects.requireNonNull(creatorUuid, "Creator uuid must not be null");
		Objects.requireNonNull(libraryUuid, "Library uuid must not be null");
		Objects.requireNonNull(binaryUuid, "Binary uuid must not be null");
		Asset asset = new AssetImpl();
		asset.setPath(filename);
		asset.setCreated(LocalDateTime.now());
		asset.setCreatorUuid(creatorUuid);
		asset.setBinaryUuid(binaryUuid);
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

	@Override
	public Tag loadTags(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Asset asset, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(Asset asset, Tag tag) {
		// TODO Auto-generated method stub
	}

}
