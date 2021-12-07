package io.metaloom.loom.db.model;

import java.time.LocalDateTime;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.model.user.LoomUser;

public abstract class AbstractCUDElement extends AbstractLoomElement implements CUDElement {

	@Override
	public LoomElement setEditor(LoomUser editor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomElement setCreator(LoomUser creator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDateTime getEdited() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomElement setEdited(LocalDateTime edate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDateTime getCreated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomElement setCreated(LocalDateTime cdate) {
		// TODO Auto-generated method stub
		return null;
	}

}
