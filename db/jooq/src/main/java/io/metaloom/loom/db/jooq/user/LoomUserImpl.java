package io.metaloom.loom.db.jooq.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.jooq.tables.records.UsersRecord;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomUserImpl implements LoomUser {

	private UsersRecord record;

	public LoomUserImpl(UsersRecord record) {
		this.record = record;
	}

	@Override
	public LoomUser setEditor(LoomUser editor) {
		record.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public LoomUser setCreator(LoomUser creator) {
		// TODO handle null
		record.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return record.getEdited();
	}

	@Override
	public LoomUser setEdited(LocalDateTime edate) {
		record.setEdited(edate);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return record.getCreated();
	}

	@Override
	public LoomUser setCreated(LocalDateTime cdate) {
		record.setCreated(cdate);
		return this;
	}

	@Override
	public UUID getUuid() {
		return record.getUuid();
	}

	@Override
	public LoomUser setUuid(UUID uuid) {
		record.setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// TODO use jsonb conversion
		return new JsonObject(record.getMeta().data());
	}

	@Override
	public LoomUser setMeta(JsonObject meta) {
		// TODO use jsonb conversion instead
		record.setMeta(JSONB.jsonb(meta.encode()));
		return this;
	}

	@Override
	public String getUsername() {
		return record.getUsername();
	}

	@Override
	public LoomUser setUsername(String username) {
		record.setUsername(username);
		return this;
	}

	@Override
	public String getPasswordHash() {
		return record.getPasswordhash();
	}

	@Override
	public LoomUser setPasswordHash(String hash) {
		record.setPasswordhash(hash);
		return this;
	}

	@Override
	public boolean isSSO() {
		// TODO handle null
		return record.getSso();
	}

	@Override
	public LoomUser setSSO(boolean flag) {
		record.setSso(flag);
		return this;
	}

	@Override
	public boolean isEnabled() {
		// TODO handle null
		return record.getEnabled();
	}

	@Override
	public LoomUser setEnabled(boolean flag) {
		record.setEnabled(flag);
		return this;
	}

	@Override
	public String getEmail() {
		return record.getEmail();
	}

	@Override
	public LoomUser setEmail(String email) {
		record.setEmail(email);
		return this;
	}

	@Override
	public String getFirstname() {
		return record.getFirstname();
	}

	@Override
	public LoomUser setFirstname(String firstname) {
		record.setFirstname(firstname);
		return this;
	}

	@Override
	public String getLastname() {
		return record.getLastname();
	}

	@Override
	public LoomUser setLastname(String lastname) {
		record.setLastname(lastname);
		return this;
	}

}
