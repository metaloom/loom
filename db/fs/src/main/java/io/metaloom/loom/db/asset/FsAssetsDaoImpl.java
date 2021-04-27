package io.metaloom.loom.db.asset;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;

public class FsAssetsDaoImpl extends AbstractFSDao implements AssetsDao {

	protected FSType getType() {
		return FSType.ASSET;
	}

	@Override
	public Asset loadAsset(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsAssetImpl.class);
	}

	@Override
	public void deleteAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		FilesystemIoHelper.delete(getType(), asset.getUuid());
	}

	@Override
	public Asset createAsset() {
		Asset asset = new FsAssetImpl();
		asset.setUuid(UUIDUtil.randomUUID());
		return asset;
	}

	@Override
	public void updateAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		FilesystemIoHelper.store(getType(), asset.getUuid(), asset);
	}

	@Override
	public void storeAsset(Asset asset) {
		Objects.requireNonNull(asset, "Asset must not be null");
		FilesystemIoHelper.store(getType(), asset.getUuid(), asset);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
