package io.metaloom.loom.rest.model.common;

/**
 * Abstract class for responses which contain editor and creator information.
 */
public abstract class AbstractCreatorEditorRestResponse extends AbstractResponse {

	private CreatorEditorStatus status = new CreatorEditorStatus();

	public AbstractCreatorEditorRestResponse() {
	}

	public CreatorEditorStatus getStatus() {
		return status;
	}

	public AbstractCreatorEditorRestResponse setStatus(CreatorEditorStatus status) {
		this.status = status;
		return this;
	}

}
