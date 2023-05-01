package io.metaloom.loom.db.jooq.dao.library;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqLibraryDao;
import io.metaloom.loom.db.model.library.Library;
import io.metaloom.loom.db.model.library.LibraryDao;

@Singleton
public class LibraryDaoImpl extends AbstractJooqDao<JooqLibraryDao> implements LibraryDao {

	@Inject
	public LibraryDaoImpl(JooqLibraryDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Library createLibrary(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeLibrary(Library library) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLibrary(Library library) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLibrary(Library library) {
		// TODO Auto-generated method stub

	}

	@Override
	public Library loadLibrary(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
