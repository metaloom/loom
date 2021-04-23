package io.metaloom.loom.rest.model.user;

import io.metaloom.loom.rest.model.RestModel;

public class UserCreateRequest implements RestModel {

	private String username;

	private String firstname;

	private String lastname;

	private String email;

	public UserCreateRequest() {
	}

	public String getUsername() {
		return username;
	}

	public UserCreateRequest setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public UserCreateRequest setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public UserCreateRequest setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserCreateRequest setEmail(String email) {
		this.email = email;
		return this;
	}

}
