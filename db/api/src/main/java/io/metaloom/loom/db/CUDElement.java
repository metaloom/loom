package io.metaloom.loom.db;

import io.metaloom.loom.db.user.User;

public interface CUDElement extends LoomElement {

	User getEditor();

	void setEditor(User editor);

	User getCreator();

	void setCreator(User creator);
}
