package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.role.RoleCreateRequest;
import io.metaloom.loom.rest.model.role.RoleListResponse;
import io.metaloom.loom.rest.model.role.RoleReference;
import io.metaloom.loom.rest.model.role.RoleResponse;
import io.metaloom.loom.rest.model.role.RoleUpdateRequest;

public class RoleExamples extends AbstractExamples {

	public static RoleResponse roleResponse() {
		RoleResponse model = new RoleResponse();
		model.setUuid(uuidA());
		model.setName("GuestPermissions");
		setCreatorEditor(model);
		return model;
	}

	public static RoleReference roleReference() {
		RoleReference model = new RoleReference();
		model.setName("GuestPermissions");
		model.setUuid(uuidA());
		return model;
	}

	public static RoleCreateRequest roleCreateRequest() {
		RoleCreateRequest model = new RoleCreateRequest();
		model.setName("GuestPermissions");
		return model;
	}

	public static RoleUpdateRequest roleUpdateRequest() {
		RoleUpdateRequest model = new RoleUpdateRequest();
		model.setName("new_role_name");
		return model;
	}

	public static RoleListResponse roleListResponse() {
		RoleListResponse model = new RoleListResponse();
		model.add(roleResponse());
		model.add(roleResponse());
		model.setMetainfo(pagingInfo());
		return model;
	}
}
