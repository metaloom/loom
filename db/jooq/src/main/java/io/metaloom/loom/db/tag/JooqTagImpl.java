package io.metaloom.loom.db.tag;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Tag;
import io.metaloom.loom.db.user.LoomUser;

public class JooqTagImpl extends AbstractJooqCUDElement implements LoomTag, JooqWrapper<Tag> {

	private final Tag delegate;

	public JooqTagImpl(Tag delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomTag setName(String name) {
		delegate.setName(name);
		return this;
	}

	@Override
	public LoomTag setCollection(String collectionName) {
		delegate.setCollection(collectionName);
		return this;
	}

	@Override
	public String getCollection() {
		return delegate.getCollection();
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
	public Tag getDelegate() {
		return delegate;
	}

}
