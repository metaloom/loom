package io.metaloom.loom.db.model.comment;

import io.metaloom.loom.db.CUDElement;

public interface Comment extends CUDElement<Comment> {

	String getTitle();

	Comment setTitle(String title);

}
