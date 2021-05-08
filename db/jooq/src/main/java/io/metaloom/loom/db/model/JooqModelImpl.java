package io.metaloom.loom.db.model;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Model;
import io.metaloom.loom.db.user.LoomUser;

public class JooqModelImpl extends AbstractJooqCUDElement implements LoomModel, JooqWrapper<Model> {

	private final Model delegate;

	public JooqModelImpl(Model delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomModel setName(String name) {
		delegate.setName(name);
		return this;
	}

	@Override
	public LocalDateTime getCdate() {
		return delegate.getCreated();
	}

	@Override
	public LocalDateTime getEdate() {
		return delegate.getEdited();
	}

	@Override
	public UUID getUuid() {
		return delegate.getUuid();
	}

	@Override
	public void setUuid(UUID uuid) {
		delegate.setUuid(uuid);
	}

	@Override
	public void setCdate(LocalDateTime cdate) {
		delegate.setCreated(cdate);
	}

	@Override
	public void setCreator(LoomUser creator) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setEdate(LocalDateTime edate) {
		delegate.setEdited(edate);
	}

	@Override
	public void setEditor(LoomUser editor) {
		// TODO Auto-generated method stub
	}

	@Override
	public Model getDelegate() {
		return delegate;
	}

}
