package io.metaloom.loom.db.mem;

import java.time.LocalDateTime;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.user.LoomUser;

public abstract class AbstractMemCUDElement extends AbstractMemLoomElement implements CUDElement {

	private LoomUser creator;
	private LocalDateTime cdate;

	private LoomUser editor;
	private LocalDateTime edate;

	@Override
	public LoomElement setEditor(LoomUser editor) {
		this.editor = editor;
		return this;
	}

	@Override
	public LocalDateTime getEdate() {
		return edate;
	}

	@Override
	public LoomElement setEdate(LocalDateTime edate) {
		this.edate = edate;
		return this;
	}

	@Override
	public LoomElement setCreator(LoomUser creator) {
		this.creator = creator;
		return this;
	}

	@Override
	public LocalDateTime getCdate() {
		return cdate;
	}

	@Override
	public LoomElement setCdate(LocalDateTime cdate) {
		this.cdate = cdate;
		return this;

	}

}
