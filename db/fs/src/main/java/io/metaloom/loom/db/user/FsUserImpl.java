package io.metaloom.loom.db.user;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.vertx.core.json.JsonObject;

public class FsUserImpl extends AbstractFSCUDElement implements LoomUser {

	private String lastname;
	private String firstname;
	private String email;
	private String username;

	private JsonObject meta;
	private boolean sso;
	private boolean enabled;
	private String passwordHash;

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
	public String getEmail() {
		return email;
	}

	@Override
	public LoomUser setEmail(String email) {
		this.email = email;
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
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public LoomUser setMeta(JsonObject meta) {
		this.meta = meta;
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

}
