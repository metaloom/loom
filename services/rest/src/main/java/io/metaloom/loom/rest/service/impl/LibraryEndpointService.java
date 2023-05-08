package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class LibraryEndpointService extends AbstractEndpointService {

	private final LibraryDao libraryDao;

	@Inject
	public LibraryEndpointService(LibraryDao libraryDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.libraryDao = libraryDao;
	}

}
