package io.metaloom.loom.rest.model.user;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class UserResponse extends AbstractCreatorEditorRestResponse {

	private String username;

	private String firstname;

	private String lastname;

	private String email;

	public UserResponse() {
	}

	public String getUsername() {
		return username;
	}

	public UserResponse setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public UserResponse setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public UserResponse setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserResponse setEmail(String email) {
		this.email = email;
		return this;
	}
}
