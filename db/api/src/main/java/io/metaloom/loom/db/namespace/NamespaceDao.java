package io.metaloom.loom.db.namespace;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface NamespaceDao extends LoomDao {

	Maybe<? extends Namespace> loadNamespace(UUID uuid);

	Namespace createNamespace();

	void deleteNamespace(Namespace namespace);

	void updateNamespace(Namespace namespace);

	void storeNamespace(Namespace namespace);

	Observable<Tag> loadTags(Namespace namespace);

	void addTag(Namespace namespace, Tag tag);

	void removeTag(Namespace namespace, Tag tag);
}
