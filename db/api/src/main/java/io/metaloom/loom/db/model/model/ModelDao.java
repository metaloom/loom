package io.metaloom.loom.db.model.model;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import io.metaloom.loom.db.Dao;
import io.metaloom.loom.db.model.tag.Tag;

public interface ModelDao extends Dao {

	/**
	 * Create a new model.
	 * 
	 * @param name
	 * @return
	 */
	default Model createModel(String name) {
		return createModel(name, null);
	}

	/**
	 * Create a new model.
	 * 
	 * @param name
	 * @param modifier
	 * @return
	 */
	Model createModel(String name, Consumer<Model> modifier);

	void deleteModel(Model model);

	void updateModel(Model model);

	Model loadModel(UUID uuid);

	void removeTag(Model model, Tag tag);

	void addTag(Model model, Tag tag);

	Stream<Tag> loadTags(Model model);

}
