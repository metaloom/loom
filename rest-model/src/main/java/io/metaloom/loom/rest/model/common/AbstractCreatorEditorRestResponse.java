package io.metaloom.loom.rest.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.user.UserReference;

/**
 * Abstract class for responses which contain editor and creator information.
 */
public abstract class AbstractCreatorEditorRestResponse extends AbstractResponse {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Reference to the creator of the element.")
	private UserReference creator;

	@JsonProperty(required = true)
	@JsonPropertyDescription("ISO8601 formatted creation date string.")
	private String created;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Reference to the editor of the element.")
	private UserReference editor;

	@JsonProperty(required = false)
	@JsonPropertyDescription("ISO8601 formatted editing date string.")
	private String edited;

	public AbstractCreatorEditorRestResponse() {
	}

	public UserReference getCreator() {
		return creator;
	}

	public AbstractCreatorEditorRestResponse setCreator(UserReference creator) {
		this.creator = creator;
		return this;
	}

	public String getCreated() {
		return created;
	}

	public AbstractCreatorEditorRestResponse setCreated(String created) {
		this.created = created;
		return this;
	}

	public UserReference getEditor() {
		return editor;
	}

	public AbstractCreatorEditorRestResponse setEditor(UserReference editor) {
		this.editor = editor;
		return this;
	}

	public String getEdited() {
		return edited;
	}

	public AbstractCreatorEditorRestResponse setEdited(String edited) {
		this.edited = edited;
		return this;
	}
}
