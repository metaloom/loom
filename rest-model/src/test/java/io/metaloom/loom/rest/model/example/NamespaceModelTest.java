package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;
import static io.metaloom.loom.rest.model.example.NamespaceExamples.namespaceCreateRequest;
import static io.metaloom.loom.rest.model.example.NamespaceExamples.namespaceListResponse;
import static io.metaloom.loom.rest.model.example.NamespaceExamples.namespaceResponse;
import static io.metaloom.loom.rest.model.example.NamespaceExamples.namespaceUpdateRequest;

import org.junit.Test;

public class NamespaceModelTest implements ModelTestcases {

	@Test
	@Override
	public void testResponse() {
		assertModel(namespaceResponse(), "NamespaceResponse");
	}

	@Test
	@Override
	public void testCreateRequest() {
		assertModel(namespaceCreateRequest(), "NamespaceCreateRequest");
	}

	@Test
	@Override
	public void testUpdateRequest() {
		assertModel(namespaceUpdateRequest(), "NamespaceUpdateRequest");
	}

	@Test
	@Override
	public void testListResponse() {
		assertModel(namespaceListResponse(), "NamespaceListResponse");
	}

	@Override
	public void testReference() {
		// Does not apply
	}

}
