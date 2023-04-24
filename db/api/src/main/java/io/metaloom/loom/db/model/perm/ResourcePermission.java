package io.metaloom.loom.db.model.perm;


public class ResourcePermission {

	private String permission;

	private String resource;

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Permission[" + getResource() + "," + getPermission() + "]";
	}

}
