package io.metaloom.loom.db.jooq.dao.asset;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrapMaybe;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.jooq.tables.daos.AssetDao;
import io.metaloom.loom.db.jooq.tables.pojos.Asset;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class LoomAssetDaoImpl extends AssetDao implements LoomAssetDao {

	private AssetDao dao;

	@Inject
	public LoomAssetDaoImpl(AssetDao dao) {
		this.dao = dao;
	}

	// protected JooqType getType() {
	// return JooqType.ASSET;
	// }

	@Override
	public Maybe<? extends LoomAsset> loadAsset(UUID uuid) {
		return wrapMaybe(dao.findById(uuid), LoomAssetImpl.class);
	}

//	@Override
//	public Completable deleteAsset(LoomAsset asset) {
//		Objects.requireNonNull(asset, "Asset must not be null");
//		return deleteById(asset.getUuid()).ignoreElement();
//	}
//
//	@Override
//	public Single<? extends LoomAsset> createAsset() {
//		Asset asset = new Asset();
//		insert(asset);
//		return insertReturningPrimary(asset).map(pk -> new LoomAssetImpl(asset.setUuid(pk)));
//	}
//
//	@Override
//	public Completable updateAsset(LoomAsset asset) {
//		Objects.requireNonNull(asset, "Asset must not be null");
//		Asset jooqAsset = unwrap(asset);
//		return update(jooqAsset).ignoreElement();
//	}

	@Override
	public Observable<LoomTag> loadTags(LoomAsset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(LoomAsset asset, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(LoomAsset asset, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public Single<? extends LoomAsset> createAsset(Consumer<LoomAsset> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteAsset(LoomAsset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateAsset(LoomAsset asset) {
		// TODO Auto-generated method stub
		return null;
	}

}
