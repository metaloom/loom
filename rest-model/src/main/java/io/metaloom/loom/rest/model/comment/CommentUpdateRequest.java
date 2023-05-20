package io.metaloom.loom.rest.model.comment;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class CommentUpdateRequest extends AbstractMetaModel<CommentUpdateRequest> implements RestRequestModel {

	private String title;

	private String text;

	public String getTitle() {
		return title;
	}

	public CommentUpdateRequest setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getText() {
		return text;
	}

	public CommentUpdateRequest setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public CommentUpdateRequest self() {
		return this;
	}
}
