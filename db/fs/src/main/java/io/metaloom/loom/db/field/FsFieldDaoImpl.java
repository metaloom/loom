package io.metaloom.loom.db.field;

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
public class FsFieldDaoImpl extends AbstractFSDao implements FieldDao {

	@Inject
	public FsFieldDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.FIELD;
	}

	@Override
	public Maybe<? extends Field> loadField(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsFieldImpl.class);
	}

	@Override
	public void deleteField(Field field) {
		Objects.requireNonNull(field, "Field must not be null");
		FilesystemIoHelper.delete(getType(), field.getUuid());
	}

	@Override
	public Field createField() {
		Field field = new FsFieldImpl();
		field.setUuid(UUIDUtil.randomUUID());
		return field;
	}

	@Override
	public void updateField(Field field) {
		Objects.requireNonNull(field, "Field must not be null");
		FilesystemIoHelper.store(getType(), field.getUuid(), field);
	}

	@Override
	public void storeField(Field field) {
		Objects.requireNonNull(field, "Field must not be null");
		FilesystemIoHelper.store(getType(), field.getUuid(), field);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
