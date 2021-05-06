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
import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class FsNamespaceDaoImpl extends AbstractFSDao implements NamespaceDao {

	@Inject
	public FsNamespaceDaoImpl(DaoCollection daos) {
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
	public Completable deleteNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		return Completable.fromAction(() -> {
			FilesystemIoHelper.delete(getType(), namespace.getUuid());
		});
	}

	@Override
	public Single<? extends Namespace> createNamespace(String name) {
		return Single.fromCallable(() -> {
			Namespace namespace = new FsNamespaceImpl();
			namespace.setUuid(UUIDUtil.randomUUID());
			namespace.setName(name);
			return namespace;
		});
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
	public Completable clear() throws IOException {
		return Completable.fromAction(() -> {
			FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
		});
	}

	@Override
	public Observable<Tag> loadTags(Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Namespace namespace, Tag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTag(Namespace namespace, Tag tag) {
		// TODO Auto-generated method stub

	}

}
