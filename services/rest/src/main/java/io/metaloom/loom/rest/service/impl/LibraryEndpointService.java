package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_LIBRARY;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_LIBRARY;
import static io.metaloom.loom.db.model.perm.Permission.READ_LIBRARY;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_LIBRARY;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.library.Library;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class LibraryEndpointService extends AbstractCRUDEndpointService<LibraryDao, Library> {

	@Inject
	public LibraryEndpointService(LibraryDao libraryDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(libraryDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_LIBRARY, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_LIBRARY, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toLibraryList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_LIBRARY, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_LIBRARY, () -> {
			String name = null;
			UUID userUuid = lrc.userUuid();
			return dao().createLibrary(userUuid, name);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_LIBRARY, () -> {
			Library library = dao().load(id);
			// TOOD update
			return dao().update(library);
		}, modelBuilder::toResponse);
	}

}
