package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.library.LibraryCreateRequest;
import io.metaloom.loom.rest.model.library.LibraryListResponse;
import io.metaloom.loom.rest.model.library.LibraryResponse;
import io.metaloom.loom.rest.model.library.LibraryUpdateRequest;

public class LibraryExamples extends AbstractExamples {

	public static LibraryResponse namespaceResponse() {
		LibraryResponse model = new LibraryResponse();
		model.setUuid(uuidC());
		model.setName("MyProject");
		model.setMeta(meta());
		setCreatorEditor(model);
		return model;
	}

	public static LibraryUpdateRequest namespaceUpdateRequest() {
		LibraryUpdateRequest model = new LibraryUpdateRequest();
		model.setName("NewProject");
		model.setMeta(meta());
		return model;
	}

	public static LibraryCreateRequest namespaceCreateRequest() {
		LibraryCreateRequest model = new LibraryCreateRequest();
		model.setName("MyProject");
		model.setMeta(meta());
		return model;
	}

	public static LibraryListResponse namespaceListResponse() {
		LibraryListResponse model = new LibraryListResponse();
		model.setMetainfo(pagingInfo());
		model.add(namespaceResponse());
		model.add(namespaceResponse());
		return model;
	}

}
