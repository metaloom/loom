package io.metaloom.loom.db.namespace;

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
public class FsNamespacesDaoImpl extends AbstractFSDao implements NamespacesDao {

	@Inject
	public FsNamespacesDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.NAMESPACE;
	}

	@Override
	public Maybe<? extends Namespace> loadNamespace(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsNamespaceImpl.class);
	}

	@Override
	public void deleteNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		FilesystemIoHelper.delete(getType(), namespace.getUuid());
	}

	@Override
	public Namespace createNamespace() {
		Namespace namespace = new FsNamespaceImpl(daos());
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
