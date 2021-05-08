package io.metaloom.loom.db.namespace;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Namespace;
import io.metaloom.loom.db.user.LoomUser;

public class JooqNamespaceImpl extends AbstractJooqCUDElement implements LoomNamespace, JooqWrapper<Namespace> {

	private final Namespace delegate;

	public JooqNamespaceImpl(Namespace delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomNamespace setName(String name) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreator(LoomUser creator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEdate(LocalDateTime edate) {
		// delegate.setEdited();

	}

	@Override
	public void setEditor(LoomUser editor) {
		// TODO Auto-generated method stub
	}

	@Override
	public Namespace getDelegate() {
		return delegate;
	}

}
