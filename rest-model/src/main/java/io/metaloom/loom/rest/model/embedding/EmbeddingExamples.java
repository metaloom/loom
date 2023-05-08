package io.metaloom.loom.rest.model.embedding;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface EmbeddingExamples extends ExampleValues {

	default EmbeddingResponse embeddingResponse() {
		EmbeddingResponse model = new EmbeddingResponse();
		model.setUuid(uuidA());
		model.setMeta(meta());
		return model;
	}
}
