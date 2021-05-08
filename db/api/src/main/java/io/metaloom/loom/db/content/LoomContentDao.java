package io.metaloom.loom.db.content;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface LoomContentDao extends LoomDao {

	Single<? extends LoomContent> createContent();

	Completable deleteContent(LoomContent content);

	Completable updateContent(LoomContent content);

	Maybe<? extends LoomContent> loadContent(UUID uuid);

	Observable<LoomTag> loadTags(LoomContent content);

	Completable addTag(LoomContent content, LoomTag tag);

	Completable removeTag(LoomContent content, LoomTag tag);

}
