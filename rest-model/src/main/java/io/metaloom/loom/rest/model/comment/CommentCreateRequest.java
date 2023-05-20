package io.metaloom.loom.rest.model.comment;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class CommentCreateRequest extends AbstractMetaModel<CommentCreateRequest> implements RestRequestModel {

	private String title;

	private String text;

	public String getTitle() {
		return title;
	}

	public CommentCreateRequest setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getText() {
		return text;
	}

	public CommentCreateRequest setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public CommentCreateRequest self() {
		return this;
	}
}
