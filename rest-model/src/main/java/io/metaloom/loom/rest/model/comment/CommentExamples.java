package io.metaloom.loom.rest.model.comment;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface CommentExamples extends ExampleValues {

	default CommentResponse commentResponse() {
		CommentResponse model = new CommentResponse();
		model.setUuid(uuidC());
		model.setTitle("The Title");
		model.setMeta(meta());
		setCreatorEditor(model);
		return model;
	}

}
