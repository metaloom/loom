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
import io.metaloom.loom.rest.model.tag.TagCreateRequest;
import io.metaloom.loom.rest.model.tag.TagUpdateRequest;
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
		list(lrc, READ_TAG, modelBuilder::toTagList);
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
			TagCreateRequest request = lrc.requestBody(TagCreateRequest.class);
			validator.validate(request);

			String name = request.getName();
			String collection = request.getCollection();
			UUID userUuid = lrc.userUuid();
			Tag tag = dao().createTag(userUuid, name, collection);
			update(request::getMeta, tag::setMeta);
			return tag;
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_TAG, () -> {
			TagUpdateRequest request = lrc.requestBody(TagUpdateRequest.class);
			validator.validate(request);

			Tag tag = dao().load(id);
			UUID userUuid = lrc.userUuid();
			update(request::getMeta, tag::setMeta);
			update(request::getName, tag::setName);
			update(request::getCollection, tag::setCollection);
			setEditor(tag, userUuid);
			return tag;
		}, modelBuilder::toResponse);
	}

}
