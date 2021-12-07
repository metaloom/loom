package io.metaloom.loom.db.asset;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsAssetDaoImpl extends AbstractFSDao implements AssetDao {

	@Inject
	public FsAssetDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.ASSET;
	}

	@Override
	public Maybe<? extends Asset> loadAsset(UUID uuid) {
		return load(uuid, FsAssetImpl.class);
	}

	@Override
	public Completable deleteAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		return delete(asset.getUuid());
	}

	@Override
	public Single<? extends Asset> createAsset() {
		Asset asset = new FsAssetImpl();
		asset.setUuid(UUIDUtil.randomUUID());
		return store(asset);
	}

	@Override
	public Completable updateAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		return store(asset).ignoreElement();
	}

	@Override
	public Observable<Tag> loadTags(Asset asset) {
		// return Observable.fromIterable(tags);
		return null;
	}

	@Override
	public Completable addTag(Asset asset, Tag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(Asset asset, Tag tag) {
		// tags.remove(tag);
		// TODO Auto-generated method stub
		return Completable.complete();
	}

}
