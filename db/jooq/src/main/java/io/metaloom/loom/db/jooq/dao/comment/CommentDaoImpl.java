package io.metaloom.loom.db.jooq.dao.comment;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqLibrary;
import io.metaloom.loom.db.model.comment.Comment;
import io.metaloom.loom.db.model.comment.CommentDao;

@Singleton
public class CommentDaoImpl extends AbstractJooqDao<Comment> implements CommentDao {

	@Inject
	public CommentDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqLibrary.LIBRARY;
	}

	@Override
	protected Class<? extends Comment> getPojoClass() {
		return CommentImpl.class;
	}

	@Override
	public Comment createComment(UUID userUuid, String title) {
		Comment comment = new CommentImpl();
		comment.setTitle(title);
		setCreatorEditor(comment, userUuid);
		return comment;
	}

}
