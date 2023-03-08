package io.metaloom.loom.db.model.namespace;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.LoomTag;

public interface LoomNamespaceDao extends LoomDao {

	/**
	 * Load the namespace with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	LoomNamespace loadNamespace(UUID uuid);

	/**
	 * Create a new namespace with the given name.
	 * 
	 * @param name
	 * @return
	 */
	LoomNamespace createNamespace(String name);

	/**
	 * Delete the namespace with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	void deleteNamespace(UUID uuid);

	/**
	 * Update the namespace with the provided POJO information.
	 * 
	 * @param namespace
	 * @return
	 */
	void updateNamespace(LoomNamespace namespace);

	/**
	 * Store the namespace with the provided POJO information.
	 * 
	 * @param namespace
	 * @return
	 */
	void storeNamespace(LoomNamespace namespace);

	/**
	 * Load the list of tags for the namespace.
	 * 
	 * @param namespace
	 * @return
	 */
	Stream<LoomTag> loadTags(LoomNamespace namespace);

	// TODO dup?
	void addTag(LoomNamespace namespace, LoomTag tag);

	// TODO dup?
	void removeTag(LoomNamespace namespace, LoomTag tag);
}
