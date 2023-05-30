package io.metaloom.loom.db.jooq.dao.embedding;

import java.util.UUID;

import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.embedding.Embedding;

public class EmbeddingImpl extends AbstractEditableElement<Embedding> implements Embedding {

	private long id;

	private Float[] data;

	private EmbeddingType type;

	private UUID assetUuid;

	public EmbeddingImpl() {
	}

	@Override
	public UUID getAssetUuid() {
		return assetUuid;
	}

	@Override
	public Embedding setAssetUuid(UUID assetUuid) {
		this.assetUuid = assetUuid;
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
