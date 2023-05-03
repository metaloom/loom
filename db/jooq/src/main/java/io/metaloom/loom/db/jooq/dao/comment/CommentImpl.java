package io.metaloom.loom.db.jooq.dao.comment;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.comment.Comment;

public class CommentImpl extends AbstractEditableElement<Comment> implements Comment {

	private String title;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Comment setTitle(String title) {
		this.title = title;
		return this;
	}

}
