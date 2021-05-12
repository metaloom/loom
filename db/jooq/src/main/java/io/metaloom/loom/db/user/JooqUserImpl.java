package io.metaloom.loom.db.user;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.vertx.core.json.JsonObject;

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
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoomUser setEnabled(boolean flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSSO() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoomUser setSSO(boolean flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(delegate.getMeta());
	}

	@Override
	public LoomUser setMeta(JsonObject meta) {
		delegate.setMeta(meta.encode());
		return this;
	}

	@Override
	public String getPasswordHash() {
		// return delegate.getPasswordHash();
		return null;
	}

	@Override
	public LoomUser setPasswordHash(String hash) {
		// delegate.setPasswordHash(hash);
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
	public LoomUser setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomUser setCdate(LocalDateTime cdate) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public LoomUser setCreator(LoomUser creator) {
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomUser setEdate(LocalDateTime edate) {
		// delegate.setEdited();
		return this;
	}

	@Override
	public LoomUser setEditor(LoomUser editor) {
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public io.metaloom.loom.db.jooq.tables.pojos.User getDelegate() {
		return delegate;
	}

}
