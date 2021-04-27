package io.metaloom.loom.db.model;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;

public class FsModelsDaoImpl extends AbstractFSDao implements ModelsDao {

	protected FSType getType() {
		return FSType.MODEL;
	}

	@Override
	public Model loadModel(UUID uuid) {
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
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
