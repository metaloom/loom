package io.metaloom.loom.db.model;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Observable;

@Singleton
public class FsModelDaoImpl extends AbstractFSDao implements ModelDao {

	@Inject
	public FsModelDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.MODEL;
	}

	@Override
	public Maybe<? extends Model> loadModel(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsModelImpl.class);
	}

	@Override
	public void deleteModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		FilesystemIoHelper.delete(getType(), model.getUuid());
	}

	@Override
	public Model createModel() {
		Model model = new FsModelImpl();
		model.setUuid(UUIDUtil.randomUUID());
		return model;
	}

	@Override
	public void updateModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		FilesystemIoHelper.store(getType(), model.getUuid(), model);
	}

	@Override
	public void storeModel(Model model) {
		Objects.requireNonNull(model, "Model must not be null");
		FilesystemIoHelper.store(getType(), model.getUuid(), model);
	}

	@Override
	public Observable<Tag> loadTags(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Model model, Tag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTag(Model model, Tag tag) {
		// TODO Auto-generated method stub

	}


}
