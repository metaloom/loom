package io.metaloom.loom.rest.model.role;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class RoleUpdateRequest implements RestModel {

	@JsonProperty(required = false)
	@JsonPropertyDescription("The new name of the role.")
	private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private Map<String, String> meta;

	@JsonProperty(required = false)
	@JsonPropertyDescription("A list of permissions that are granted by the role.")
	private List<RolePermission> permissions;

	public RoleUpdateRequest() {
	}

	public String getName() {
		return name;
	}

	public RoleUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public RoleUpdateRequest setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

	public List<RolePermission> getPermissions() {
		return permissions;
	}

	public RoleUpdateRequest setPermissions(List<RolePermission> permissions) {
		this.permissions = permissions;
		return this;
	}

}
