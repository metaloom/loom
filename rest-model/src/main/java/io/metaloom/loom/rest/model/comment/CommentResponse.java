package io.metaloom.loom.rest.model.comment;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class CommentResponse extends AbstractCreatorEditorRestResponse<CommentResponse> {

	private String title;

	public String getTitle() {
		return title;
	}

	public CommentResponse setTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public CommentResponse self() {
		return this;
	}

}
