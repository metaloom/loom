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

	void updateNamespace(LoomNamespace namespace);

	void storeNamespace(LoomNamespace namespace);

	Observable<LoomTag> loadTags(LoomNamespace namespace);

	void addTag(LoomNamespace namespace, LoomTag tag);

	void removeTag(LoomNamespace namespace, LoomTag tag);
}
