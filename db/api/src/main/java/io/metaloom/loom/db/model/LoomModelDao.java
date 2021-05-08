package io.metaloom.loom.db.model;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface LoomModelDao extends LoomDao {

	Single<? extends LoomModel> createModel();

	Completable deleteModel(LoomModel model);

	Completable updateModel(LoomModel model);

	Maybe<? extends LoomModel> loadModel(UUID uuid);

	Completable removeTag(LoomModel model, LoomTag tag);

	Completable addTag(LoomModel model, LoomTag tag);

	Observable<LoomTag> loadTags(LoomModel model);

}
