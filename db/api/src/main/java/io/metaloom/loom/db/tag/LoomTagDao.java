package io.metaloom.loom.db.tag;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface LoomTagDao extends LoomDao {

	Single<? extends LoomTag> createTag(String name, String collection);

	Completable deleteTag(LoomTag tag);

	Completable updateTag(LoomTag tag);

	Maybe<? extends LoomTag> loadTag(UUID uuid);

}
