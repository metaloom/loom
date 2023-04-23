package io.metaloom.loom.db;

import java.time.LocalDateTime;

import io.metaloom.loom.db.model.user.User;

public interface CUDElement extends Element {

//	User getEditor();

	Element setEditor(User editor);

//	User getCreator();

	Element setCreator(User creator);

	LocalDateTime getEdited();

	Element setEdited(LocalDateTime edate);

	LocalDateTime getCreated();

	Element setCreated(LocalDateTime cdate);
}
