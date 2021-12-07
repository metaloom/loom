package io.metaloom.loom.db.model.namespace;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface NamespaceDao extends LoomDao {

	/**
	 * Load the namespace with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Maybe<? extends Namespace> loadNamespace(UUID uuid);

	/**
	 * Create a new namespace with the given name.
	 * 
	 * @param name
	 * @return
	 */
	default Single<? extends Namespace> createNamespace(String name) {
		return createNamespace(name, null);
	}

	/**
	 * Create a new namespace with the given name.
	 * 
	 * @param name
	 * @param modifier
	 * @return
	 */
	Single<? extends Namespace> createNamespace(String name, Consumer<Namespace> modifier);

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
	Completable updateNamespace(Namespace namespace);

	/**
	 * Load the list of tags for the namespace.
	 * 
	 * @param namespace
	 * @return
	 */
	Observable<Tag> loadTags(Namespace namespace);

	// TODO dup?
	Completable addTag(Namespace namespace, Tag tag);

	// TODO dup?
	Completable removeTag(Namespace namespace, Tag tag);
}
