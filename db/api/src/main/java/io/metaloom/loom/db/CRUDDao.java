package io.metaloom.loom.db;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.page.Page;

public interface CRUDDao<T extends Element<T>> extends Dao {

	default void delete(T element) {
		delete(element.getUuid());
	}

	/**
	 * Delete the element with the given uuid.
	 * 
	 * @param uuid
	 */
	void delete(UUID uuid);

	T update(T element);

	T load(UUID uuid);

	/**
	 * Store the element.
	 * 
	 * @param element
	 */
	void store(T element);

	/**
	 * Load a page of elements.
	 * 
	 * @param fromUuid
	 * @param pageSize
	 * @return
	 */
	Page<T> loadPage(UUID fromUuid, int pageSize);

	Stream<? extends T> findAll();

}
