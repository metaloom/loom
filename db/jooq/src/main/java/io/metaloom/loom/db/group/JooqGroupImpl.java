package io.metaloom.loom.db.group;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Group;
import io.metaloom.loom.db.user.LoomUser;

public class JooqGroupImpl extends AbstractJooqCUDElement implements LoomGroup, JooqWrapper<Group> {

	private final Group delegate;

	public JooqGroupImpl(Group delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomGroup setName(String name) {
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
		delegate.setCreatorUuid(creator.getUuid());
	}

	@Override
	public void setEdate(LocalDateTime edate) {
		delegate.setEdited(edate);
	}

	@Override
	public void setEditor(LoomUser editor) {
		delegate.setEditorUuid(editor.getUuid());
	}

	@Override
	public Group getDelegate() {
		return delegate;
	}

}
