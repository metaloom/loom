package io.metaloom.loom.db.model.embedding;

import io.metaloom.loom.db.CUDElement;

public interface Embedding extends CUDElement<Embedding> {

	Long getEmbeddingId();

	Embedding setEmbeddingId(Long id);

}
