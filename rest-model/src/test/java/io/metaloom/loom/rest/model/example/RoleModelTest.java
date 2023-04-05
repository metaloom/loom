package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;
import static io.metaloom.loom.rest.model.example.RoleExamples.roleCreateRequest;
import static io.metaloom.loom.rest.model.example.RoleExamples.roleListResponse;
import static io.metaloom.loom.rest.model.example.RoleExamples.roleReference;
import static io.metaloom.loom.rest.model.example.RoleExamples.roleResponse;
import static io.metaloom.loom.rest.model.example.RoleExamples.roleUpdateRequest;

import org.junit.jupiter.api.Test;

public class RoleModelTest implements ModelTestcases {

	@Test
	@Override
	public void testResponse() {
		assertModel(roleResponse(), "RoleResponse");
	}

	@Test
	@Override
	public void testCreateRequest() {
		assertModel(roleCreateRequest(), "RoleCreateRequest");
	}

	@Test
	@Override
	public void testUpdateRequest() {
		assertModel(roleUpdateRequest(), "RoleUpdateRequest");
	}

	@Test
	@Override
	public void testReference() {
		assertModel(roleReference(), "RoleReference");
	}

	@Test
	@Override
	public void testListResponse() {
		assertModel(roleListResponse(), "RoleListResponse");
	}
}
