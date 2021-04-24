package io.metaloom.loom.rest.model.role;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class RoleCreateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The name of the new role")
	private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private Map<String, String> meta;

	@JsonProperty(required = false)
	@JsonPropertyDescription("A list of permissions that are granted by the role.")
	private List<RolePermission> permissions;

	public RoleCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public RoleCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public RoleCreateRequest setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

	public List<RolePermission> getPermissions() {
		return permissions;
	}

	public RoleCreateRequest setPermissions(List<RolePermission> permissions) {
		this.permissions = permissions;
		return this;
	}

}
