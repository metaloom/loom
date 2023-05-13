package io.metaloom.loom.db.jooq.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDaoTestcases;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.comment.Comment;
import io.metaloom.loom.db.model.comment.CommentDao;
import io.metaloom.loom.db.model.user.User;

public class CommentDaoTest extends AbstractJooqTest implements CRUDDaoTestcases<CommentDao, Comment, UUID> {

	@Override
	public CommentDao getDao() {
		return commentDao();
	}

	@Override
	public Comment createElement(User user, int i) {
		return getDao().createComment(user, "title_" + i);
	}

	@Override
	public void assertUpdate(Comment updatedElement) {
		assertEquals("updated_title", updatedElement.getTitle());
	}

	@Override
	public void updateElement(Comment comment) {
		comment.setTitle("updated_title");
	}

}
