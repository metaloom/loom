package io.metaloom.loom.db;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.filter.Filter;
import io.metaloom.loom.db.page.Page;

/**
 * @param <T>
 *            Element type for the DTO
 * @param <UUID>
 *            Type of the id
 */
public interface CRUDDao<T extends Element<T>> extends Dao {

	default void delete(T element) {
		delete(element.getUuid());
	}

	/**
	 * Delete the element with the given id.
	 * 
	 * @param id
	 */
	void delete(UUID id);

	T update(T element);

	T load(UUID id);

	/**
	 * Store the element.
	 * 
	 * @param element
	 */
	void store(T element);

	/**
	 * Load a page of elements.
	 * 
	 * @param fromId
	 * @param pageSize
	 * @param filters
	 * @return
	 */
	Page<T> loadPage(UUID fromId, int pageSize, Set<Filter> filters);

	Stream<? extends T> findAll();

}
