package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.model.ModelCreateRequest;
import io.metaloom.loom.rest.model.model.ModelListResponse;
import io.metaloom.loom.rest.model.model.ModelReference;
import io.metaloom.loom.rest.model.model.ModelResponse;
import io.metaloom.loom.rest.model.model.ModelUpdateRequest;

public class ModelExamples extends AbstractExamples {

	public static ModelResponse modelResponse() {
		ModelResponse model = new ModelResponse();
		model.setUuid(uuidC());
		model.setName("BlogPost");
		setCreatorEditor(model);
		return model;
	}

	public static ModelUpdateRequest modelUpdateRequest() {
		ModelUpdateRequest model = new ModelUpdateRequest();
		model.setName("NewBlogPost");
		return model;
	}

	public static ModelReference modelReference() {
		ModelReference model = new ModelReference();
		model.setUuid(uuidC());
		model.setName("BlogPost");
		return model;
	}

	public static ModelCreateRequest modelCreateRequest() {
		ModelCreateRequest model = new ModelCreateRequest();
		model.setName("BlogPost");
		return model;
	}

	public static ModelListResponse modelListResponse() {
		ModelListResponse model = new ModelListResponse();
		model.setMetainfo(pagingInfo());
		model.add(modelResponse());
		model.add(modelResponse());
		return model;
	}

}
