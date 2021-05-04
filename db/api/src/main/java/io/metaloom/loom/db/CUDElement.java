package io.metaloom.loom.db;

import java.time.LocalDateTime;

import io.metaloom.loom.db.user.User;

public interface CUDElement extends LoomElement {

	User getEditor();

	void setEditor(User editor);

	User getCreator();

	void setCreator(User creator);

	LocalDateTime getEdate();

	void setEdate(LocalDateTime edate);

	LocalDateTime getCdate();

	void setCdate(LocalDateTime cdate);
}
