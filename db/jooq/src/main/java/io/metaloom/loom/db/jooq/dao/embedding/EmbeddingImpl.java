package io.metaloom.loom.db.jooq.dao.embedding;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.embedding.Embedding;

public class EmbeddingImpl extends AbstractEditableElement<Embedding> implements Embedding {

	private Long editableId;

	public EmbeddingImpl() {
	}

	@Override
	public Long getEmbeddingId() {
		return editableId;
	}

	@Override
	public Embedding setEmbeddingId(Long id) {
		this.editableId = id;
		return this;
	}

}
