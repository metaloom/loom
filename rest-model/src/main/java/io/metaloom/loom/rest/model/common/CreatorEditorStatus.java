package io.metaloom.loom.rest.model.common;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.user.UserReference;

public class CreatorEditorStatus {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Reference to the creator of the element.")
	private UserReference creator;

	@JsonProperty(required = true)
	@JsonPropertyDescription("ISO8601 formatted creation date string.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date created;

	@JsonProperty(required = true)
	@JsonPropertyDescription("Reference to the editor of the element.")
	private UserReference editor;

	@JsonProperty(required = true)
	@JsonPropertyDescription("ISO8601 formatted editing date string.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date edited;

	public UserReference getCreator() {
		return creator;
	}

	public CreatorEditorStatus setCreator(UserReference creator) {
		this.creator = creator;
		return this;
	}

	public Date getCreated() {
		return created;
	}

	public CreatorEditorStatus setCreated(Date created) {
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

	public Date getEdited() {
		return edited;
	}

	public CreatorEditorStatus setEdited(Date edited) {
		this.edited = edited;
		return this;
	}

}
