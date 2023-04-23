package io.metaloom.loom.db.mem;

import java.time.LocalDateTime;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.Element;
import io.metaloom.loom.db.model.user.User;

public abstract class AbstractMemCUDElement extends AbstractMemLoomElement implements CUDElement {

	private User creator;
	private LocalDateTime cdate;

	private User editor;
	private LocalDateTime edate;

	@Override
	public Element setEditor(User editor) {
		this.editor = editor;
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return edate;
	}

	@Override
	public Element setEdited(LocalDateTime edate) {
		this.edate = edate;
		return this;
	}

	@Override
	public Element setCreator(User creator) {
		this.creator = creator;
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return cdate;
	}

	@Override
	public Element setCreated(LocalDateTime cdate) {
		this.cdate = cdate;
		return this;

	}

}
