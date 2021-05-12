package io.metaloom.loom.db.field;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsFieldDaoImpl extends AbstractFSDao implements LoomFieldDao {

	@Inject
	public FsFieldDaoImpl(LoomDaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.FIELD;
	}

	@Override
	public Maybe<? extends LoomField> loadField(UUID uuid) {
		return load(uuid, FsFieldImpl.class);
	}

	@Override
	public Completable deleteField(LoomField field) {
		Objects.requireNonNull(field, "Field must not be null");
		return delete(field.getUuid());
	}

	@Override
	public Single<? extends LoomField> createField() {
		LoomField field = new FsFieldImpl();
		field.setUuid(UUIDUtil.randomUUID());
		return Single.just(field);
	}

	@Override
	public Completable updateField(LoomField field) {
		Objects.requireNonNull(field, "Field must not be null");
		return store(field).ignoreElement();
	}

}
