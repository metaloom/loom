package io.metaloom.loom.db.jooq.dao.user;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqUser;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class JooqUserImpl extends AbstractWrappedElement<JooqUser> implements LoomUser {

	public JooqUserImpl(JooqUser delegate) {
		super(delegate);
	}

	@Override
	public String getUsername() {
		return delegate().getUsername();
	}

	@Override
	public LoomUser setUsername(String username) {
		delegate().setUsername(username);
		return this;
	}

	@Override
	public String getEmail() {
		return delegate().getEmail();
	}

	@Override
	public LoomUser setEmail(String email) {
		delegate().setEmail(email);
		return this;
	}

	@Override
	public String getFirstname() {
		return delegate().getFirstname();
	}

	@Override
	public LoomUser setFirstname(String firstname) {
		delegate().setFirstname(firstname);
		return this;
	}

	@Override
	public String getLastname() {
		return delegate().getLastname();
	}

	@Override
	public LoomUser setLastname(String lastname) {
		this.setLastname(lastname);
		return this;
	}

	@Override
	public boolean isEnabled() {
		// TODO check for NPE
		return delegate().getEnabled();
	}

	@Override
	public LoomUser setEnabled(boolean flag) {
		delegate().setEnabled(flag);
		return this;
	}

	@Override
	public boolean isSSO() {
		// TODO check for NPE
		return delegate().getSso();
	}

	@Override
	public LoomUser setSSO(boolean flag) {
		delegate().setSso(flag);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// return new JsonObject(delegate().getMeta());
		return null;
	}

	@Override
	public LoomUser setMeta(JsonObject meta) {
		// delegate().setMeta(meta.encode());
		return this;
	}

	@Override
	public String getPasswordHash() {
		return delegate().getPasswordhash();
	}

	@Override
	public LoomUser setPasswordHash(String hash) {
		delegate().setPasswordhash(hash);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate().getEdited();
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public LoomUser setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public LoomUser setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public LoomUser setCreator(LoomUser creator) {
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomUser setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public LoomUser setEditor(LoomUser editor) {
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

}
