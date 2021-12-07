package io.metaloom.loom.db.model.content;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface ContentDao extends LoomDao {

	Single<? extends Content> createContent();

	Completable deleteContent(Content content);

	Completable updateContent(Content content);

	Maybe<? extends Content> loadContent(UUID uuid);

	Observable<Tag> loadTags(Content content);

	Completable addTag(Content content, Tag tag);

	Completable removeTag(Content content, Tag tag);

}
