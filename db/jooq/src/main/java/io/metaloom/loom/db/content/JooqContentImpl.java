package io.metaloom.loom.db.content;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.user.User;

public class JooqContentImpl extends AbstractJooqCUDElement implements Content, JooqWrapper<io.metaloom.loom.db.jooq.tables.pojos.Content> {

	private final io.metaloom.loom.db.jooq.tables.pojos.Content delegate;

	public JooqContentImpl(io.metaloom.loom.db.jooq.tables.pojos.Content delegate) {
		this.delegate = delegate;
	}

	@Override
	public LocalDateTime getCdate() {
		return delegate.getCreated();
	}

	@Override
	public LocalDateTime getEdate() {
		// TODO Auto-generated method stub
		return null;
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
	public void setCreator(User creator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEdate(LocalDateTime edate) {
		// delegate.setEdited();

	}

	@Override
	public void setEditor(User editor) {
		// TODO Auto-generated method stub
	}

	@Override
	public io.metaloom.loom.db.jooq.tables.pojos.Content getDelegate() {
		return delegate;
	}

}
