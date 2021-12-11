package io.metaloom.loom.db.jooq.dao.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomUserImpl implements LoomUser {

	private User pojo;

	public LoomUserImpl(User pojo) {
		this.pojo = pojo;
	}

	@Override
	public LoomUser setEditor(LoomUser editor) {
		pojo.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public LoomUser setCreator(LoomUser creator) {
		// TODO handle null
		pojo.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return pojo.getEdited();
	}

	@Override
	public LoomUser setEdited(LocalDateTime edate) {
		pojo.setEdited(edate);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return pojo.getCreated();
	}

	@Override
	public LoomUser setCreated(LocalDateTime cdate) {
		pojo.setCreated(cdate);
		return this;
	}

	@Override
	public UUID getUuid() {
		return pojo.getUuid();
	}

	@Override
	public LoomUser setUuid(UUID uuid) {
		pojo.setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// TODO use jsonb conversion
		return new JsonObject(pojo.getMeta().data());
	}

	@Override
	public LoomUser setMeta(JsonObject meta) {
		// TODO use jsonb conversion instead
		pojo.setMeta(JSONB.jsonb(meta.encode()));
		return this;
	}

	@Override
	public String getUsername() {
		return pojo.getUsername();
	}

	@Override
	public LoomUser setUsername(String username) {
		pojo.setUsername(username);
		return this;
	}

	@Override
	public String getPasswordHash() {
		return pojo.getPasswordhash();
	}

	@Override
	public LoomUser setPasswordHash(String hash) {
		pojo.setPasswordhash(hash);
		return this;
	}

	@Override
	public boolean isSSO() {
		// TODO handle null
		return pojo.getSso();
	}

	@Override
	public LoomUser setSSO(boolean flag) {
		pojo.setSso(flag);
		return this;
	}

	@Override
	public boolean isEnabled() {
		// TODO handle null
		return pojo.getEnabled();
	}

	@Override
	public LoomUser setEnabled(boolean flag) {
		pojo.setEnabled(flag);
		return this;
	}

	@Override
	public String getEmail() {
		return pojo.getEmail();
	}

	@Override
	public LoomUser setEmail(String email) {
		pojo.setEmail(email);
		return this;
	}

	@Override
	public String getFirstname() {
		return pojo.getFirstname();
	}

	@Override
	public LoomUser setFirstname(String firstname) {
		pojo.setFirstname(firstname);
		return this;
	}

	@Override
	public String getLastname() {
		return pojo.getLastname();
	}

	@Override
	public LoomUser setLastname(String lastname) {
		pojo.setLastname(lastname);
		return this;
	}

}
