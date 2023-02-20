package io.metaloom.loom.db.model.model;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.LoomTag;

public interface LoomModelDao extends LoomDao {

	/**
	 * Create a new model.
	 * 
	 * @param name
	 * @return
	 */
	default LoomModel createModel(String name) {
		return createModel(name, null);
	}

	/**
	 * Create a new model.
	 * 
	 * @param name
	 * @param modifier
	 * @return
	 */
	LoomModel createModel(String name, Consumer<LoomModel> modifier);

	void deleteModel(LoomModel model);

	void updateModel(LoomModel model);

	LoomModel loadModel(UUID uuid);

	void removeTag(LoomModel model, LoomTag tag);

	void addTag(LoomModel model, LoomTag tag);

	Stream<LoomTag> loadTags(LoomModel model);

}
