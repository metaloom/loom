package io.metaloom.loom.db.model.model;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface ModelDao extends LoomDao {

	/**
	 * Create a new model.
	 * 
	 * @param name
	 * @return
	 */
	default Single<? extends Model> createModel(String name) {
		return createModel(name, null);
	}

	/**
	 * Create a new model.
	 * 
	 * @param name
	 * @param modifier
	 * @return
	 */
	Single<? extends Model> createModel(String name, Consumer<Model> modifier);

	Completable deleteModel(Model model);

	Completable updateModel(Model model);

	Maybe<? extends Model> loadModel(UUID uuid);

	Completable removeTag(Model model, Tag tag);

	Completable addTag(Model model, Tag tag);

	Observable<Tag> loadTags(Model model);

}
