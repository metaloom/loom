package io.metaloom.loom.rest.model.library;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface LibraryExamples extends ExampleValues {

	default LibraryResponse libraryResponse() {
		LibraryResponse model = new LibraryResponse();
		model.setUuid(uuidC());
		model.setName("MyProject");
		model.setMeta(meta());
		setCreatorEditor(model);
		return model;
	}

	default LibraryUpdateRequest libraryUpdateRequest() {
		LibraryUpdateRequest model = new LibraryUpdateRequest();
		model.setName("NewProject");
		model.setMeta(meta());
		return model;
	}

	default LibraryCreateRequest libraryCreateRequest() {
		LibraryCreateRequest model = new LibraryCreateRequest();
		model.setName("MyProject");
		model.setMeta(meta());
		return model;
	}

	default LibraryListResponse libraryListResponse() {
		LibraryListResponse model = new LibraryListResponse();
		model.setMetainfo(pagingInfo());
		model.add(libraryResponse());
		model.add(libraryResponse());
		return model;
	}

}
