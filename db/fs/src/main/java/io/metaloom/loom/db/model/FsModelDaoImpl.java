package io.metaloom.loom.db.model;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.db.tag.LoomTag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Observable;

@Singleton
public class FsModelDaoImpl extends AbstractFSDao implements LoomModelDao {

	@Inject
	public FsModelDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.MODEL;
	}

	@Override
	public Maybe<? extends LoomModel> loadModel(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsModelImpl.class);
	}

	@Override
	public void deleteModel(LoomModel model) {
		Objects.requireNonNull(model, "Model must not be null");
		FilesystemIoHelper.delete(getType(), model.getUuid());
	}

	@Override
	public LoomModel createModel() {
		LoomModel model = new FsModelImpl();
		model.setUuid(UUIDUtil.randomUUID());
		return model;
	}

	@Override
	public void updateModel(LoomModel model) {
		Objects.requireNonNull(model, "Model must not be null");
		FilesystemIoHelper.store(getType(), model.getUuid(), model);
	}

	@Override
	public void storeModel(LoomModel model) {
		Objects.requireNonNull(model, "Model must not be null");
		FilesystemIoHelper.store(getType(), model.getUuid(), model);
	}

	@Override
	public Observable<LoomTag> loadTags(LoomModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(LoomModel model, LoomTag tag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTag(LoomModel model, LoomTag tag) {
		// TODO Auto-generated method stub

	}


}
