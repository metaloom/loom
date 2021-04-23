package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.tag.TagCreateRequest;
import io.metaloom.loom.rest.model.tag.TagListResponse;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.metaloom.loom.rest.model.tag.TagResponse;
import io.metaloom.loom.rest.model.tag.TagUpdateRequest;

public final class TagExamples extends AbstractExamples {

	public static TagResponse tagResponse() {
		TagResponse model = new TagResponse();
		model.setUuid(uuidB());
		model.setName("red");
		model.setCollection("colors");
		setCreatorEditor(model);
		return model;
	}

	public static TagCreateRequest tagCreateRequest() {
		TagCreateRequest model = new TagCreateRequest();
		model.setName("red");
		model.setCollection("colors");
		return model;
	}

	public static TagUpdateRequest tagUpdateRequest() {
		TagUpdateRequest model = new TagUpdateRequest();
		model.setName("red");
		model.setCollection("colors");
		return model;
	}

	public static TagListResponse tagListResponse() {
		TagListResponse model = new TagListResponse();
		model.setMetainfo(pagingInfo());
		model.add(tagResponse());
		model.add(tagResponse());
		return model;
	}

	public static TagReference tagReference() {
		return tagReferenceA();
	}

}
