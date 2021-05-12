package io.metaloom.loom.db.namespace;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
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
public class FsNamespaceDaoImpl extends AbstractFSDao implements LoomNamespaceDao {

	@Inject
	public FsNamespaceDaoImpl(LoomDaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.NAMESPACE;
	}

	@Override
	public Maybe<? extends LoomNamespace> loadNamespace(UUID uuid) {
		return load(uuid, FsNamespaceImpl.class);
	}

	@Override
	public Completable deleteNamespace(UUID uuid) {
		Objects.requireNonNull(uuid, "Namespace uuid must not be null");
		return delete(uuid);
	}

	@Override
	public Single<? extends LoomNamespace> createNamespace(String name) {
		return Single.fromCallable(() -> {
			LoomNamespace namespace = new FsNamespaceImpl();
			namespace.setUuid(UUIDUtil.randomUUID());
			namespace.setName(name);
			return namespace;
		});
	}

	@Override
	public Completable updateNamespace(LoomNamespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		return store(namespace).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		return clearTypeDir();
	}

	@Override
	public Observable<LoomTag> loadTags(LoomNamespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(LoomNamespace namespace, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(LoomNamespace namespace, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

}
