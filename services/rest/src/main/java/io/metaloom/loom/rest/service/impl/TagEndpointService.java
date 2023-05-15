package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_TAG;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_TAG;
import static io.metaloom.loom.db.model.perm.Permission.READ_TAG;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_TAG;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.tag.TagDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;

@Singleton
public class TagEndpointService extends AbstractCRUDEndpointService<TagDao, Tag> {

	private static final Logger log = LoggerFactory.getLogger(TagEndpointService.class);

	@Inject
	public TagEndpointService(TagDao tagDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(tagDao, daos, modelBuilder, validator);
	}
	
	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_TAG, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_TAG, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toTagList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_TAG, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_TAG, () -> {
			String name = null;
			String collection = null;
			UUID userUuid = lrc.userUuid();
			return dao().createTag(userUuid, name, collection);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_TAG, () -> {
			Tag tag = dao().load(id);
			// TOOD update
			return dao().update(tag);
		}, modelBuilder::toResponse);
	}

}
