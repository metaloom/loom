package io.metaloom.loom.db.group;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.user.User;

public class JooqGroupImpl extends AbstractJooqCUDElement implements Group, JooqWrapper<io.metaloom.loom.db.jooq.tables.pojos.Group> {

	private final io.metaloom.loom.db.jooq.tables.pojos.Group delegate;

	public JooqGroupImpl(io.metaloom.loom.db.jooq.tables.pojos.Group delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public Group setName(String name) {
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
	public void setCreator(User creator) {
		delegate.setCreatorUuid(creator.getUuid());
	}

	@Override
	public void setEdate(LocalDateTime edate) {
		delegate.setEdited(edate);
	}

	@Override
	public void setEditor(User editor) {
		delegate.setEditorUuid(editor.getUuid());
	}

	@Override
	public io.metaloom.loom.db.jooq.tables.pojos.Group getDelegate() {
		return delegate;
	}

}
