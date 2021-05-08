package io.metaloom.loom.db.role;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Role;
import io.metaloom.loom.db.user.LoomUser;

public class JooqRoleImpl extends AbstractJooqCUDElement implements LoomRole, JooqWrapper<Role> {

	private final Role delegate;

	public JooqRoleImpl(Role delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomRole setName(String name) {
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
	public Role getDelegate() {
		return delegate;
	}

}
