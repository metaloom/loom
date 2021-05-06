package io.metaloom.loom.db.model;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface ModelDao extends LoomDao {

	Model createModel();

	void deleteModel(Model model);

	void updateModel(Model model);

	Maybe<? extends Model> loadModel(UUID uuid);

	void storeModel(Model model);

	void removeTag(Model model, Tag tag);

	void addTag(Model model, Tag tag);

	Observable<Tag> loadTags(Model model);

}
