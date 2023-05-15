package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_COLLECTION;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_COLLECTION;
import static io.metaloom.loom.db.model.perm.Permission.READ_COLLECTION;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_COLLECTION;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.collection.Collection;
import io.metaloom.loom.db.model.collection.CollectionDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;

@Singleton
public class CollectionEndpointService extends AbstractCRUDEndpointService<CollectionDao, Collection> {

	private static final Logger log = LoggerFactory.getLogger(CollectionEndpointService.class);

	@Inject
	public CollectionEndpointService(CollectionDao collectionDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(collectionDao, daos, modelBuilder, validator);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_COLLECTION, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_COLLECTION, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toCollectionList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_COLLECTION, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_COLLECTION, () -> {
			String name = null;
			UUID userUuid = lrc.userUuid();
			return dao().createCollection(userUuid, name);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_COLLECTION, () -> {
			Collection collection = dao().load(id);
			// TOOD update
			return dao().update(collection);
		}, modelBuilder::toResponse);
	}
}
