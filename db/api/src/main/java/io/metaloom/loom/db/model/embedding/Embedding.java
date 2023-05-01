package io.metaloom.loom.db.model.embedding;

import io.metaloom.loom.db.Element;
import io.metaloom.loom.db.MetaElement;

public interface Embedding extends Element, MetaElement {

	Long getEmbeddingId();

	Embedding setEmbeddingId(Long id);

}
