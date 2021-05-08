package io.metaloom.loom.db.asset;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.db.tag.LoomTag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Observable;

@Singleton
public class FsAssetDaoImpl extends AbstractFSDao implements LoomAssetDao {

	@Inject
	public FsAssetDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.ASSET;
	}

	@Override
	public Maybe<? extends LoomAsset> loadAsset(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsAssetImpl.class);
	}

	@Override
	public void deleteAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		FilesystemIoHelper.delete(getType(), asset.getUuid());
	}

	@Override
	public LoomAsset createAsset() {
		LoomAsset asset = new FsAssetImpl();
		asset.setUuid(UUIDUtil.randomUUID());
		return asset;
	}

	@Override
	public void updateAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		FilesystemIoHelper.store(getType(), asset.getUuid(), asset);
	}

	@Override
	public void storeAsset(LoomAsset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		FilesystemIoHelper.store(getType(), asset.getUuid(), asset);
	}

	@Override
	public Observable<LoomTag> loadTags(LoomAsset asset) {
		// return Observable.fromIterable(tags);
		return null;
	}

	@Override
	public void addTag(LoomAsset asset, LoomTag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTag(LoomAsset asset, LoomTag tag) {
		// tags.remove(tag);
		// TODO Auto-generated method stub
	}

}
