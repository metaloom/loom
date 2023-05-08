package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;

import org.junit.jupiter.api.Test;

public class NamespaceModelTest implements ModelTestcases {

	@Test
	@Override
	public void testResponse() {
		assertModel(libraryResponse(), "NamespaceResponse");
	}

	@Test
	@Override
	public void testCreateRequest() {
		assertModel(libraryCreateRequest(), "NamespaceCreateRequest");
	}

	@Test
	@Override
	public void testUpdateRequest() {
		assertModel(libraryUpdateRequest(), "NamespaceUpdateRequest");
	}

	@Test
	@Override
	public void testListResponse() {
		assertModel(libraryListResponse(), "NamespaceListResponse");
	}

	@Override
	public void testReference() {
		// Does not apply
	}

}
