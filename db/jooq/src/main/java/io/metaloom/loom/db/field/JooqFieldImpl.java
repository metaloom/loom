package io.metaloom.loom.db.field;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.db.user.User;
import io.reactivex.Observable;

public class JooqFieldImpl extends AbstractJooqCUDElement implements Field, JooqWrapper<io.metaloom.loom.db.jooq.tables.pojos.Field> {

	private final io.metaloom.loom.db.jooq.tables.pojos.Field delegate;

	public JooqFieldImpl(io.metaloom.loom.db.jooq.tables.pojos.Field delegate) {
		super(null);
		this.delegate = delegate;
	}

	@Override
	public User getCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getEditor() {
		// TODO Auto-generated method stub
		return null;
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
	public io.metaloom.loom.db.jooq.tables.pojos.Field getDelegate() {
		return delegate;
	}

	@Override
	public LocalDateTime getCdate() {
		// TODO Auto-generated method stub
		return null;
	}

}
