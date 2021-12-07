package io.metaloom.loom.db;

import java.io.IOException;

import io.reactivex.rxjava3.core.Completable;

public interface LoomDao {

	/**
	 * Clear the elements that are managed by the DAO.
	 * 
	 * @throws IOException
	 */
	Completable clear() throws IOException;
}
