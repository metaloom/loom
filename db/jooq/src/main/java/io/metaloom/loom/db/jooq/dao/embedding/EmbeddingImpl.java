package io.metaloom.loom.db.jooq.dao.embedding;

import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingType;

public class EmbeddingImpl extends AbstractEditableElement<Embedding> implements Embedding {

	private long id;

	private Float[] data;

	private EmbeddingType type;

	private UUID binaryUuid;

	public EmbeddingImpl() {
	}

	@Override
	public UUID getBinaryUuid() {
		return binaryUuid;
	}

	@Override
	public Embedding setBinaryUuid(UUID binaryUuid) {
		this.binaryUuid = binaryUuid;
		return this;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public Embedding setId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public EmbeddingType getType() {
		return type;
	}

	@Override
	public Embedding setType(EmbeddingType type) {
		this.type = type;
		return this;
	}

	@Override
	public Float[] getData() {
		return data;
	}

	@Override
	public Embedding setData(Float[] vectorData) {
		this.data = vectorData;
		return this;
	}

}
