package io.metaloom.loom.db.group;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;
import io.reactivex.Observable;

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
	public Observable<Role> streamRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group addRole(Role role) {

		return this;
	}

	@Override
	public Group addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group removeRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group removeUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<User> streamUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public io.metaloom.loom.db.jooq.tables.pojos.Group getDelegate() {
		return delegate;
	}

}
