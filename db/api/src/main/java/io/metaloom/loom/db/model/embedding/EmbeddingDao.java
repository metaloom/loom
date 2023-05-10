package io.metaloom.loom.db.model.embedding;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.user.User;

public interface EmbeddingDao extends CRUDDao<Embedding> {

	default Embedding createEmbedding(User user, Asset binary, float[] data, EmbeddingType type, long id) {
		return createEmbedding(user.getUuid(), binary.getUuid(), data, type, id);
	}

	Embedding createEmbedding(UUID userUuid, UUID binaryUuid, float[] data, EmbeddingType type, long id);

}
