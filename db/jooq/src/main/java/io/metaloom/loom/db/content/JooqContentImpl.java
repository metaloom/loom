package io.metaloom.loom.db.content;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Content;
import io.metaloom.loom.db.user.LoomUser;

public class JooqContentImpl extends AbstractJooqCUDElement implements LoomContent, JooqWrapper<Content> {

	private final Content delegate;

	public JooqContentImpl(Content delegate) {
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
	public Content getDelegate() {
		return delegate;
	}

}
