package io.metaloom.loom.rest.model.user;

import io.metaloom.loom.rest.model.RestModel;

public class UserUpdateRequest implements RestModel {

	private String username;

	private String firstname;

	private String lastname;

	private String email;

	public UserUpdateRequest() {
	}

	public String getUsername() {
		return username;
	}

	public UserUpdateRequest setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public UserUpdateRequest setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public UserUpdateRequest setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserUpdateRequest setEmail(String email) {
		this.email = email;
		return this;
	}

}
