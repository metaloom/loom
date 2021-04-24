package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.namespace.NamespaceCreateRequest;
import io.metaloom.loom.rest.model.namespace.NamespaceListResponse;
import io.metaloom.loom.rest.model.namespace.NamespaceResponse;
import io.metaloom.loom.rest.model.namespace.NamespaceUpdateRequest;

public class NamespaceExamples extends AbstractExamples {

	public static NamespaceResponse namespaceResponse() {
		NamespaceResponse model = new NamespaceResponse();
		model.setUuid(uuidC());
		model.setName("MyProject");
		model.setMeta(meta());
		setCreatorEditor(model);
		return model;
	}

	public static NamespaceUpdateRequest namespaceUpdateRequest() {
		NamespaceUpdateRequest model = new NamespaceUpdateRequest();
		model.setName("NewProject");
		model.setMeta(meta());
		return model;
	}

	public static NamespaceCreateRequest namespaceCreateRequest() {
		NamespaceCreateRequest model = new NamespaceCreateRequest();
		model.setName("MyProject");
		model.setMeta(meta());
		return model;
	}

	public static NamespaceListResponse namespaceListResponse() {
		NamespaceListResponse model = new NamespaceListResponse();
		model.setMetainfo(pagingInfo());
		model.add(namespaceResponse());
		model.add(namespaceResponse());
		return model;
	}

}
