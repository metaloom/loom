package io.metaloom.loom.db.extension;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;

@Singleton
public class FsExtensionDaoImpl extends AbstractFSDao implements ExtensionDao {

	@Inject
	public FsExtensionDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.EXTENSION;
	}

	@Override
	public Maybe<? extends Extension> loadExtension(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsExtensionImpl.class);
	}

	@Override
	public void deleteExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		FilesystemIoHelper.delete(getType(), extension.getUuid());
	}

	@Override
	public Extension createExtension() {
		Extension extension = new FsExtensionImpl();
		extension.setUuid(UUIDUtil.randomUUID());
		return extension;
	}

	@Override
	public void updateExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		FilesystemIoHelper.store(getType(), extension.getUuid(), extension);
	}

	@Override
	public void storeExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		FilesystemIoHelper.store(getType(), extension.getUuid(), extension);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
