package io.metaloom.loom.db.namespace;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface NamespacesDao extends LoomDao {

	Maybe<? extends Namespace> loadNamespace(UUID uuid);

	Namespace createNamespace();

	void deleteNamespace(Namespace namespace);

	void updateNamespace(Namespace namespace);

	void storeNamespace(Namespace namespace);
}
