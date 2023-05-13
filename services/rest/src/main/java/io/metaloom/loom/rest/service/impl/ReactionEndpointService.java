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
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class ReactionEndpointService extends AbstractCRUDEndpointService<ReactionDao, Reaction, UUID> {

	@Inject
	public ReactionEndpointService(ReactionDao reactionDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(reactionDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_REACTION, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_REACTION, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toReactionList);
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
			UUID userUuid = lrc.userUuid();
			String type = null;
			return dao().createReaction(userUuid, type);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_REACTION, () -> {
			Reaction reaction = dao().load(id);
			// TOOD update
			return dao().update(reaction);
		}, modelBuilder::toResponse);
	}
}
