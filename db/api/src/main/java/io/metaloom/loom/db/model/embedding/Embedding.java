package io.metaloom.loom.db.model.embedding;

import java.util.UUID;

import io.metaloom.loom.db.CUDElement;

public interface Embedding extends CUDElement<Embedding> {

	UUID getBinaryUuid();

	Embedding setBinaryUuid(UUID binaryUuid);

	Float[] getData();

	Embedding setData(Float[] vectorData);

	long getId();

	Embedding setId(long id);

	EmbeddingType getType();

	Embedding setType(EmbeddingType type);

}
