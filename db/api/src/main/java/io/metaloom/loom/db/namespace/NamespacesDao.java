package io.metaloom.loom.db.namespace;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface NamespacesDao extends LoomDao {

	Namespace loadNamespace(UUID uuid);

	Namespace createNamespace();

	void deleteNamespace(Namespace namespace);

	void updateNamespace(Namespace namespace);

	void storeNamespace(Namespace namespace);
}
