package io.metaloom.loom.rest.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.user.UserReference;

public class CreatorEditorStatus {

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

	public UserReference getCreator() {
		return creator;
	}

	public CreatorEditorStatus setCreator(UserReference creator) {
		this.creator = creator;
		return this;
	}

	public String getCreated() {
		return created;
	}

	public CreatorEditorStatus setCreated(String created) {
		this.created = created;
		return this;
	}

	public UserReference getEditor() {
		return editor;
	}

	public CreatorEditorStatus setEditor(UserReference editor) {
		this.editor = editor;
		return this;
	}

	public String getEdited() {
		return edited;
	}

	public CreatorEditorStatus setEdited(String edited) {
		this.edited = edited;
		return this;
	}

}
