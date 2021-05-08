package io.metaloom.loom.db.field;

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
public class FsFieldDaoImpl extends AbstractFSDao implements LoomFieldDao {

	@Inject
	public FsFieldDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.FIELD;
	}

	@Override
	public Maybe<? extends LoomField> loadField(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsFieldImpl.class);
	}

	@Override
	public void deleteField(LoomField field) {
		Objects.requireNonNull(field, "Field must not be null");
		FilesystemIoHelper.delete(getType(), field.getUuid());
	}

	@Override
	public LoomField createField() {
		LoomField field = new FsFieldImpl();
		field.setUuid(UUIDUtil.randomUUID());
		return field;
	}

	@Override
	public void updateField(LoomField field) {
		Objects.requireNonNull(field, "Field must not be null");
		FilesystemIoHelper.store(getType(), field.getUuid(), field);
	}

	@Override
	public void storeField(LoomField field) {
		Objects.requireNonNull(field, "Field must not be null");
		FilesystemIoHelper.store(getType(), field.getUuid(), field);
	}

}
