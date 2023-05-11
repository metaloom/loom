package io.metaloom.loom.db.model.embedding;

import java.util.UUID;

import io.metaloom.loom.db.CUDElement;

public interface Embedding extends CUDElement<Embedding> {

	UUID getAssetUuid();

	Embedding setAssetUuid(UUID assetUuid);

	Float[] getData();

	Embedding setData(Float[] vectorData);

	long getId();

	Embedding setId(long id);

	EmbeddingType getType();

	Embedding setType(EmbeddingType type);

}
