package io.metaloom.loom.db.asset;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.tag.LoomTag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsAssetDaoImpl extends AbstractFSDao implements LoomAssetDao {

	@Inject
	public FsAssetDaoImpl(DaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.ASSET;
	}

	@Override
	public Maybe<? extends LoomAsset> loadAsset(UUID uuid) {
		return load(uuid, FsAssetImpl.class);
	}

	@Override
	public Completable deleteAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		return delete(asset.getUuid());
	}

	@Override
	public Single<? extends LoomAsset> createAsset() {
		LoomAsset asset = new FsAssetImpl();
		asset.setUuid(UUIDUtil.randomUUID());
		return store(asset);
	}

	@Override
	public Completable updateAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		return store(asset).ignoreElement();
	}

	@Override
	public Observable<LoomTag> loadTags(LoomAsset asset) {
		// return Observable.fromIterable(tags);
		return null;
	}

	@Override
	public Completable addTag(LoomAsset asset, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(LoomAsset asset, LoomTag tag) {
		// tags.remove(tag);
		// TODO Auto-generated method stub
		return Completable.complete();
	}

}
