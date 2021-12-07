package io.metaloom.loom.db.namespace;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsNamespaceDaoImpl extends AbstractFSDao implements NamespaceDao {

	@Inject
	public FsNamespaceDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.NAMESPACE;
	}

	@Override
	public Maybe<? extends Namespace> loadNamespace(UUID uuid) {
		return load(uuid, FsNamespaceImpl.class);
	}

	@Override
	public Completable deleteNamespace(UUID uuid) {
		Objects.requireNonNull(uuid, "Namespace uuid must not be null");
		return delete(uuid);
	}

	@Override
	public Single<? extends Namespace> createNamespace(String name, Consumer<Namespace> modifier) {
		return Single.defer(() -> {
			Namespace namespace = new FsNamespaceImpl();
			namespace.setUuid(UUIDUtil.randomUUID());
			namespace.setName(name);
			if (modifier != null) {
				modifier.accept(namespace);
			}
			return store(namespace);
		});
	}

	@Override
	public Completable updateNamespace(Namespace namespace) {
		return store(namespace).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		return clearTypeDir();
	}

	@Override
	public Observable<Tag> loadTags(Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(Namespace namespace, Tag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(Namespace namespace, Tag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

}
