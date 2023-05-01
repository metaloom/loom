package io.metaloom.loom.db.model.embedding;

import java.util.UUID;

import io.metaloom.loom.db.Dao;

public interface EmbeddingDao extends Dao {

	Embedding createEmbedding(String source, float[] embeddings, FaceOrigin origin);

	void deleteFace(UUID uuid);

}
