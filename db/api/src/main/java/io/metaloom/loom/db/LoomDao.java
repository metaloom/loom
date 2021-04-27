package io.metaloom.loom.db;

import java.io.IOException;

public interface LoomDao {

	/**
	 * Clear the elements that are managed by the DAO.
	 * 
	 * @throws IOException
	 */
	void clear() throws IOException;
}
