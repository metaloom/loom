package io.metaloom.loom.db.extension;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsExtensionDaoImpl extends AbstractFSDao implements LoomExtensionDao {

	@Inject
	public FsExtensionDaoImpl(DaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.EXTENSION;
	}

	@Override
	public Maybe<? extends LoomExtension> loadExtension(UUID uuid) {
		return load(uuid, FsExtensionImpl.class);
	}

	@Override
	public Completable deleteExtension(LoomExtension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		return delete(extension.getUuid());
	}

	@Override
	public Single<? extends LoomExtension> createExtension() {
		LoomExtension extension = new FsExtensionImpl();
		extension.setUuid(UUIDUtil.randomUUID());
		return store(extension);
	}

	@Override
	public Completable updateExtension(LoomExtension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		return store(extension).ignoreElement();
	}

}
