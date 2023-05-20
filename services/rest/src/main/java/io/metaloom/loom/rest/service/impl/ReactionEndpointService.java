package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_REACTION;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_REACTION;
import static io.metaloom.loom.db.model.perm.Permission.READ_REACTION;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_REACTION;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.reaction.Reaction;
import io.metaloom.loom.db.model.reaction.ReactionDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.reaction.ReactionCreateRequest;
import io.metaloom.loom.rest.model.reaction.ReactionUpdateRequest;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;

@Singleton
public class ReactionEndpointService extends AbstractCRUDEndpointService<ReactionDao, Reaction> {

	@Inject
	public ReactionEndpointService(ReactionDao reactionDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(reactionDao, daos, modelBuilder, validator);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_REACTION, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_REACTION, modelBuilder::toReactionList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_REACTION, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_REACTION, () -> {
			ReactionCreateRequest request = lrc.requestBody(ReactionCreateRequest.class);
			validator.validate(request);

			UUID userUuid = lrc.userUuid();
			String type = null;
			Reaction reaction = dao().createReaction(userUuid, type);
			update(request::getMeta, reaction::setMeta);
			return reaction;
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_REACTION, () -> {
			ReactionUpdateRequest request = lrc.requestBody(ReactionUpdateRequest.class);
			validator.validate(request);

			UUID userUuid = lrc.userUuid();
			Reaction reaction = dao().load(id);
			// TODO update
			// update(request::getType, reaction::setType);
			update(request::getMeta, reaction::setMeta);
			setEditor(reaction, userUuid);
			return reaction;
		}, modelBuilder::toResponse);
	}
}
