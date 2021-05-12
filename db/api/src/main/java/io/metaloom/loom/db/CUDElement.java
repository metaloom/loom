package io.metaloom.loom.db;

import java.time.LocalDateTime;

import io.metaloom.loom.db.user.LoomUser;

public interface CUDElement extends LoomElement {

//	User getEditor();

	LoomElement setEditor(LoomUser editor);

//	User getCreator();

	LoomElement setCreator(LoomUser creator);

	LocalDateTime getEdate();

	LoomElement setEdate(LocalDateTime edate);

	LocalDateTime getCdate();

	LoomElement setCdate(LocalDateTime cdate);
}
