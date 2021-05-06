package io.metaloom.loom.db.user;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsUserImpl extends AbstractFSCUDElement implements User {

	private String lastname;
	private String firstname;
	private String email;
	private String username;

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public String getFirstname() {
		return firstname;
	}

	@Override
	public User setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	@Override
	public String getLastname() {
		return lastname;
	}

	@Override
	public User setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

}
