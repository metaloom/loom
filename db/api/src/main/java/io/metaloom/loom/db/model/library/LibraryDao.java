package io.metaloom.loom.db.model.library;

import java.util.UUID;

import io.metaloom.loom.db.Dao;

public interface LibraryDao extends Dao {

	Library createLibrary(String name);

	void storeLibrary(Library library);

	void updateLibrary(Library library);

	void deleteLibrary(Library library);

	Library loadLibrary(UUID uuid);

	long count();
}
