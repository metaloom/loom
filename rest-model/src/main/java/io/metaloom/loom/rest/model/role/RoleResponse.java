package io.metaloom.loom.rest.model.role;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class RoleResponse extends AbstractCreatorEditorRestResponse {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The name of the role")
	private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private Map<String, String> meta;

	@JsonProperty(required = false)
	@JsonPropertyDescription("A list of permissions that are granted by the role.")
	private List<RolePermission> permissions;

	public RoleResponse() {
	}

	public String getName() {
		return name;
	}

	public RoleResponse setName(String name) {
		this.name = name;
		return this;
	}

	public List<RolePermission> getPermissions() {
		return permissions;
	}

	public RoleResponse setPermissions(List<RolePermission> permissions) {
		this.permissions = permissions;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public RoleResponse setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}
}
