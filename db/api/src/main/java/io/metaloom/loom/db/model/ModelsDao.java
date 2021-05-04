package io.metaloom.loom.db.model;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface ModelsDao extends LoomDao {

	Model createModel();

	void deleteModel(Model model);

	void updateModel(Model model);

	Maybe<? extends Model> loadModel(UUID uuid);

	void storeModel(Model model);

}
