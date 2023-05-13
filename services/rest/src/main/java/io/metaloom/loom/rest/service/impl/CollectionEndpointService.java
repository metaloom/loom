package io.metaloom.loom.rest.service.impl;

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

@Singleton
public class CollectionEndpointService extends AbstractCRUDEndpointService<CollectionDao, Collection, UUID> {

	private static final Logger log = LoggerFactory.getLogger(CollectionEndpointService.class);

	@Inject
	public CollectionEndpointService(CollectionDao collectionDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(collectionDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID  uuid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub
		
	}

}
