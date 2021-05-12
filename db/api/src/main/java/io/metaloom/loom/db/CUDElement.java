package io.metaloom.loom.db;

import java.time.LocalDateTime;

import io.metaloom.loom.db.user.LoomUser;

public interface CUDElement extends LoomElement {

//	User getEditor();

	LoomElement setEditor(LoomUser editor);

//	User getCreator();

	LoomElement setCreator(LoomUser creator);

	LocalDateTime getEdited();

	LoomElement setEdited(LocalDateTime edate);

	LocalDateTime getCreated();

	LoomElement setCreated(LocalDateTime cdate);
}
