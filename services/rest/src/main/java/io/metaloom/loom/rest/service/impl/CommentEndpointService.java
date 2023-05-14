package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_COMMENT;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_COMMENT;
import static io.metaloom.loom.db.model.perm.Permission.READ_COMMENT;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_COMMENT;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.comment.Comment;
import io.metaloom.loom.db.model.comment.CommentDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class CommentEndpointService extends AbstractCRUDEndpointService<CommentDao, Comment> {

	@Inject
	public CommentEndpointService(CommentDao commentDao,  DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(commentDao, daos, modelBuilder);
	}

	
	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_COMMENT, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_COMMENT, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toCommentList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_COMMENT, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_COMMENT, () -> {
			UUID userUuid = lrc.userUuid();
			String title = null;
			return dao().createComment(userUuid, title);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_COMMENT, () -> {
			Comment comment = dao().load(id);
			// TOOD update
			return dao().update(comment);
		}, modelBuilder::toResponse);
	}
}
