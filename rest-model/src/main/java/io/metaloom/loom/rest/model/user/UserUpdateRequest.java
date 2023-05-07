package io.metaloom.loom.rest.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class UserUpdateRequest extends AbstractMetaModel<UserUpdateRequest> {

	@JsonProperty(required = false)
	@JsonPropertyDescription("The new username of the user.")
	private String username;

	@JsonProperty(required = false)
	@JsonPropertyDescription("The firstname of the user.")
	private String firstname;

	@JsonPropertyDescription("The lastname of the user.")
	@JsonProperty(required = false)
	private String lastname;

	@JsonProperty(required = false)
	@JsonPropertyDescription("The email address of the user.")
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

	@Override
	public UserUpdateRequest self() {
		return this;
	}

}
