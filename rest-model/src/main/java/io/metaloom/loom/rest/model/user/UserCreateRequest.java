package io.metaloom.loom.rest.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.vertx.core.json.JsonObject;

public class UserCreateRequest implements RestRequestModel, MetaModel<UserCreateRequest> {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The username of the new user.")
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

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private JsonObject meta;

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

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public UserCreateRequest setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public UserCreateRequest self() {
		return this;
	}

}
