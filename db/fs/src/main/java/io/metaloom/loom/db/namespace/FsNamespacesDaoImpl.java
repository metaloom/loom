package io.metaloom.loom.db.namespace;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;

public class FsNamespacesDaoImpl extends AbstractFSDao implements NamespacesDao {

	protected FSType getType() {
		return FSType.NAMESPACE;
	}

	@Override
	public Namespace loadNamespace(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsNamespaceImpl.class);
	}

	@Override
	public void deleteNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		FilesystemIoHelper.delete(getType(), namespace.getUuid());
	}

	@Override
	public Namespace createNamespace() {
		Namespace namespace = new FsNamespaceImpl();
		namespace.setUuid(UUIDUtil.randomUUID());
		return namespace;
	}

	@Override
	public void updateNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		FilesystemIoHelper.store(getType(), namespace.getUuid(), namespace);
	}

	@Override
	public void storeNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		FilesystemIoHelper.store(getType(), namespace.getUuid(), namespace);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
