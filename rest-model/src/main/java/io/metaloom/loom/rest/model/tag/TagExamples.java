package io.metaloom.loom.rest.model.tag;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface TagExamples extends ExampleValues {

	default TagResponse tagResponse() {
		TagResponse model = new TagResponse();
		model.setUuid(uuidB());
		model.setName("red");
		model.setCollection("colors");
		model.setMeta(meta());
		setCreatorEditor(model);
		return model;
	}

	default TagCreateRequest tagCreateRequest() {
		TagCreateRequest model = new TagCreateRequest();
		model.setName("red");
		model.setCollection("colors");
		model.setMeta(meta());
		return model;
	}

	default TagUpdateRequest tagUpdateRequest() {
		TagUpdateRequest model = new TagUpdateRequest();
		model.setName("red");
		model.setCollection("colors");
		model.setMeta(meta());
		return model;
	}

	default TagListResponse tagListResponse() {
		TagListResponse model = new TagListResponse();
		model.setMetainfo(pagingInfo());
		model.add(tagResponse());
		model.add(tagResponse());
		return model;
	}

	default TagReference tagReference() {
		return tagReferenceA();
	}

}
