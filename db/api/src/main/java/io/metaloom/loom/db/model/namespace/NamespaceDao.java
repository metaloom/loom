package io.metaloom.loom.db.model.namespace;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.Dao;
import io.metaloom.loom.db.model.tag.Tag;

public interface NamespaceDao extends Dao {

	/**
	 * Load the namespace with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Namespace loadNamespace(UUID uuid);

	/**
	 * Create a new namespace with the given name.
	 * 
	 * @param name
	 * @return
	 */
	Namespace createNamespace(String name);

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
	void updateNamespace(Namespace namespace);

	/**
	 * Store the namespace with the provided POJO information.
	 * 
	 * @param namespace
	 * @return
	 */
	void storeNamespace(Namespace namespace);

	/**
	 * Load the list of tags for the namespace.
	 * 
	 * @param namespace
	 * @return
	 */
	Stream<Tag> loadTags(Namespace namespace);

	// TODO dup?
	void addTag(Namespace namespace, Tag tag);

	// TODO dup?
	void removeTag(Namespace namespace, Tag tag);
}
