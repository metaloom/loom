package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.role.RoleListResponse;
import io.metaloom.loom.rest.model.role.RoleResponse;

public interface RoleModelBuilder extends ModelBuilder, UserModelBuilder {

	default RoleResponse toResponse(Role role, User creator, User editor) {
		RoleResponse response = new RoleResponse();
		response.setName(role.getName());
		setStatus(role, creator, editor, response);
		return response;
	}

	default RoleListResponse toRoleList(Page<Role> page) {
		RoleListResponse response = new RoleListResponse();
		for (Role role : page) {
			response.add(toResponse(role, null, null));
		}
		return response;
	}
}
