package io.metaloom.loom.db.field;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsFieldDaoImpl extends AbstractFSDao implements FieldDao {

	@Inject
	public FsFieldDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.FIELD;
	}

	@Override
	public Maybe<? extends Field> loadField(UUID uuid) {
		return load(uuid, FsFieldImpl.class);
	}

	@Override
	public Completable deleteField(Field field) {
		Objects.requireNonNull(field, "Field must not be null");
		return delete(field.getUuid());
	}

	@Override
	public Single<? extends Field> createField() {
		Field field = new FsFieldImpl();
		field.setUuid(UUIDUtil.randomUUID());
		return Single.just(field);
	}

	@Override
	public Completable updateField(Field field) {
		Objects.requireNonNull(field, "Field must not be null");
		return store(field).ignoreElement();
	}

}
