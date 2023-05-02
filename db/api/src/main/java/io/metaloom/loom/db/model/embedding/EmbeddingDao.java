package io.metaloom.loom.db.model.embedding;

import io.metaloom.loom.db.CRUDDao;

public interface EmbeddingDao extends CRUDDao<Embedding> {

	Embedding createEmbedding(String source, float[] embeddings, FaceOrigin origin);

}
