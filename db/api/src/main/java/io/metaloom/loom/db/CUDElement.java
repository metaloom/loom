package io.metaloom.loom.db;

import java.time.LocalDateTime;

import io.metaloom.loom.db.user.LoomUser;

public interface CUDElement extends LoomElement {

//	User getEditor();

	void setEditor(LoomUser editor);

//	User getCreator();

	void setCreator(LoomUser creator);

	LocalDateTime getEdate();

	void setEdate(LocalDateTime edate);

	LocalDateTime getCdate();

	void setCdate(LocalDateTime cdate);
}
