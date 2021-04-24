package io.metaloom.loom.rest.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class UserResponse extends AbstractCreatorEditorRestResponse {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The username of the user.")
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
