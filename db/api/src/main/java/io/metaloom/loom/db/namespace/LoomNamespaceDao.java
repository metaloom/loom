package io.metaloom.loom.db.namespace;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface LoomNamespaceDao extends LoomDao {

	/**
	 * Load the namespace with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Maybe<? extends LoomNamespace> loadNamespace(UUID uuid);

	/**
	 * Create a new namespace with the given name.
	 * 
	 * @param name
	 * @return
	 */
	Single<? extends LoomNamespace> createNamespace(String name);

	/**
	 * Delete the namespace with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Completable deleteNamespace(UUID uuid);

	/**
	 * Update the namespace with the provided POJO information.
	 * 
	 * @param namespace
	 * @return
	 */
	Completable updateNamespace(LoomNamespace namespace);

	/**
	 * Load the list of tags for the namespace.
	 * 
	 * @param namespace
	 * @return
	 */
	Observable<LoomTag> loadTags(LoomNamespace namespace);

	// TODO dup?
	Completable addTag(LoomNamespace namespace, LoomTag tag);

	// TODO dup?
	Completable removeTag(LoomNamespace namespace, LoomTag tag);
}
