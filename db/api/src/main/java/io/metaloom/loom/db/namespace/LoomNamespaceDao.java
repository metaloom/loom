package io.metaloom.loom.db.namespace;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface LoomNamespaceDao extends LoomDao {

	Maybe<? extends LoomNamespace> loadNamespace(UUID uuid);

	Single<? extends LoomNamespace> createNamespace(String name);

	Completable deleteNamespace(LoomNamespace namespace);

	Completable updateNamespace(LoomNamespace namespace);

	Observable<LoomTag> loadTags(LoomNamespace namespace);

	Completable addTag(LoomNamespace namespace, LoomTag tag);

	Completable removeTag(LoomNamespace namespace, LoomTag tag);
}
