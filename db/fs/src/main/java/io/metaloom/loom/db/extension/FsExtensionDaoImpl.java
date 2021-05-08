package io.metaloom.loom.db.extension;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;

@Singleton
public class FsExtensionDaoImpl extends AbstractFSDao implements LoomExtensionDao {

	@Inject
	public FsExtensionDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.EXTENSION;
	}

	@Override
	public Maybe<? extends LoomExtension> loadExtension(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsExtensionImpl.class);
	}

	@Override
	public void deleteExtension(LoomExtension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		FilesystemIoHelper.delete(getType(), extension.getUuid());
	}

	@Override
	public LoomExtension createExtension() {
		LoomExtension extension = new FsExtensionImpl();
		extension.setUuid(UUIDUtil.randomUUID());
		return extension;
	}

	@Override
	public void updateExtension(LoomExtension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		FilesystemIoHelper.store(getType(), extension.getUuid(), extension);
	}

	@Override
	public void storeExtension(LoomExtension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		FilesystemIoHelper.store(getType(), extension.getUuid(), extension);
	}

}
