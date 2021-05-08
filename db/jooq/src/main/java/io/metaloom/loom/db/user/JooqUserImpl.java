package io.metaloom.loom.db.user;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.User;

public class JooqUserImpl extends AbstractJooqCUDElement implements LoomUser, JooqWrapper<User> {

	private final User delegate;

	public JooqUserImpl(User delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getUsername() {
		return delegate.getUsername();
	}

	@Override
	public LoomUser setUsername(String username) {
		delegate.setUsername(username);
		return this;
	}

	@Override
	public String getEmail() {
		return delegate.getEmail();
	}

	@Override
	public LoomUser setEmail(String email) {
		delegate.setEmail(email);
		return this;
	}

	@Override
	public String getFirstname() {
		return delegate.getFirstname();
	}

	@Override
	public LoomUser setFirstname(String firstname) {
		delegate.setFirstname(firstname);
		return this;
	}

	@Override
	public String getLastname() {
		return delegate.getLastname();
	}

	@Override
	public LoomUser setLastname(String lastname) {
		this.setLastname(lastname);
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
	public io.metaloom.loom.db.jooq.tables.pojos.User getDelegate() {
		return delegate;
	}

}
