package io.metaloom.loom.db.model;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface LoomModelDao extends LoomDao {

	LoomModel createModel();

	void deleteModel(LoomModel model);

	void updateModel(LoomModel model);

	Maybe<? extends LoomModel> loadModel(UUID uuid);

	void storeModel(LoomModel model);

	void removeTag(LoomModel model, LoomTag tag);

	void addTag(LoomModel model, LoomTag tag);

	Observable<LoomTag> loadTags(LoomModel model);

}
