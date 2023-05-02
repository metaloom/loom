package io.metaloom.loom.db.model.library;

import io.metaloom.loom.db.CRUDDao;

public interface LibraryDao extends CRUDDao<Library> {

	Library createLibrary(String name);

}
