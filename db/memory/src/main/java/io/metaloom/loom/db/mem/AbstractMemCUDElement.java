package io.metaloom.loom.db.mem;

import java.time.LocalDateTime;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.user.User;

public abstract class AbstractMemCUDElement extends AbstractMemLoomElement implements CUDElement {

	private User creator;
	private LocalDateTime cdate;

	private User editor;
	private LocalDateTime edate;


	@Override
	public void setEditor(User editor) {
		this.editor = editor;
	}

	@Override
	public LocalDateTime getEdate() {
		return edate;
	}

	@Override
	public void setEdate(LocalDateTime edate) {
		this.edate = edate;
	}

	@Override
	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Override
	public LocalDateTime getCdate() {
		return cdate;
	}

	@Override
	public void setCdate(LocalDateTime cdate) {
		this.cdate = cdate;

	}

}
