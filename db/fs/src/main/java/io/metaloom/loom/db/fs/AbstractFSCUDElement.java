package io.metaloom.loom.db.fs;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.user.User;

public abstract class AbstractFSCUDElement extends AbstractFSLoomElement implements CUDElement {

	private User creator;
	private Long cdate;

	private User editor;
	private Long edate;

	@Override
	public User getEditor() {
		return editor;
	}

	@Override
	public void setEditor(User editor) {
		this.editor = editor;
	}

	@Override
	public Long getEdate() {
		return edate;
	}

	@Override
	public void setEdate(Long edate) {
		this.edate = edate;
	}

	@Override
	public User getCreator() {
		return creator;
	}

	@Override
	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Override
	public Long getCdate() {
		return cdate;
	}

	@Override
	public void setCdate(Long cdate) {
		this.cdate = cdate;
	}

}
