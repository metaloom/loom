package io.metaloom.loom.db.jooq.dao.user;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomUserPojoImpl implements LoomUser {

	private UUID creatorUuid;
	private UUID editorUuid;
	private JsonObject meta;
	private String username;
	private UUID uuid;
	private LocalDateTime edate;
	private LocalDateTime cdate;
	private String email;
	private String firstname;
	private String lastname;
	private String passwordHash;
	private boolean sso;
	private boolean enabled;

	public LoomUserPojoImpl() {
	}

	public LoomUserPojoImpl(UUID uuid, String username) {
		this.uuid = uuid;
		this.username = username;
	}

	@Override
	public LoomUser setEditor(LoomUser editor) {
		this.editorUuid = editor.getUuid();
		return this;
	}

	@Override
	public LoomUser setCreator(LoomUser creator) {
		this.creatorUuid = creator.getUuid();
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return edate;
	}

	@Override
	public LoomUser setEdited(LocalDateTime edate) {
		this.edate = edate;
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return cdate;
	}

	@Override
	public LoomUser setCreated(LocalDateTime cdate) {
		this.cdate = cdate;
		return this;
	}

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public LoomUser setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public LoomUser setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public LoomUser setUsername(String username) {
		this.username = username;
		return this;
	}

	@Override
	public String getFirstname() {
		return firstname;
	}

	@Override
	public LoomUser setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	@Override
	public String getLastname() {
		return lastname;
	}

	@Override
	public LoomUser setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public LoomUser setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public String getPasswordHash() {
		return passwordHash;
	}

	@Override
	public LoomUser setPasswordHash(String hash) {
		this.passwordHash = hash;
		return this;
	}

	@Override
	public boolean isSSO() {
		return sso;
	}

	@Override
	public LoomUser setSSO(boolean flag) {
		this.sso = flag;
		return this;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public LoomUser setEnabled(boolean flag) {
		this.enabled = flag;
		return this;
	}

	@Override
	public String toString() {
		return "uuid:" + getUuid() + ",username:" + getUsername();
	}

}
