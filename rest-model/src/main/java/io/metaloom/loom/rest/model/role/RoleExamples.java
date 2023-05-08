package io.metaloom.loom.rest.model.role;

import java.util.Arrays;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface RoleExamples extends ExampleValues {

	default RoleResponse roleResponse() {
		RoleResponse model = new RoleResponse();
		model.setUuid(uuidA());
		model.setName("GuestPermissions");
		model.setMeta(meta());
		model.setPermissions(Arrays.asList(RolePermission.CREATE_USER));
		setCreatorEditor(model);
		return model;
	}

	default RoleReference roleReference() {
		RoleReference model = new RoleReference();
		model.setName("GuestPermissions");
		model.setUuid(uuidA());
		return model;
	}

	default RoleCreateRequest roleCreateRequest() {
		RoleCreateRequest model = new RoleCreateRequest();
		model.setName("GuestPermissions");
		model.setPermissions(Arrays.asList(RolePermission.CREATE_USER));
		model.setMeta(meta());
		return model;
	}

	default RoleUpdateRequest roleUpdateRequest() {
		RoleUpdateRequest model = new RoleUpdateRequest();
		model.setName("new_role_name");
		model.setPermissions(Arrays.asList(RolePermission.CREATE_USER));
		model.setMeta(meta());
		return model;
	}

	default RoleListResponse roleListResponse() {
		RoleListResponse model = new RoleListResponse();
		model.add(roleResponse());
		model.add(roleResponse());
		model.setMetainfo(pagingInfo());
		return model;
	}
}
