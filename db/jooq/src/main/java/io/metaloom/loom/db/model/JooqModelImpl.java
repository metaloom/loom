package io.metaloom.loom.db.model;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.db.user.User;
import io.reactivex.Observable;

public class JooqModelImpl extends AbstractJooqCUDElement implements Model, JooqWrapper<io.metaloom.loom.db.jooq.tables.pojos.Model> {

	private final io.metaloom.loom.db.jooq.tables.pojos.Model delegate;

	public JooqModelImpl(io.metaloom.loom.db.jooq.tables.pojos.Model delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public Model setName(String name) {
		delegate.setName(name);
		return this;
	}

	@Override
	public User getCreator() {
		// TODO Auto-generated method stub
		return null;
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
	public User getEditor() {
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
		delegate.setCreated(cdate);
	}

	@Override
	public void setCreator(User creator) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setEdate(LocalDateTime edate) {
		delegate.setEdited(edate);
	}

	@Override
	public void setEditor(User editor) {
		// TODO Auto-generated method stub
	}

	@Override
	public Observable<Tag> getTags() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addTag(Tag tag) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void removeTag(Tag tag) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public io.metaloom.loom.db.jooq.tables.pojos.Model getDelegate() {
		return delegate;
	}

}
