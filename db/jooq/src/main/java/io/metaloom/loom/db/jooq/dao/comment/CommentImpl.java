package io.metaloom.loom.db.jooq.dao.comment;

import javax.persistence.Column;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.comment.Comment;

public class CommentImpl extends AbstractEditableElement<Comment> implements Comment {

	private String title;

	@Column(name = "content")
	private String text;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Comment setTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public String getText() {
		return text;
	}

	public String getContent() {
		return text;
	}

	@Override
	public Comment setText(String text) {
		this.text = text;
		return this;
	}

}
