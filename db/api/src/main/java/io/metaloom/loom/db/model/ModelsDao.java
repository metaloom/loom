package io.metaloom.loom.db.model;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface ModelsDao extends LoomDao {

	Model createModel();

	void deleteModel(Model model);

	void updateModel(Model model);

	Model loadModel(UUID uuid);

	void storeModel(Model model);

}
