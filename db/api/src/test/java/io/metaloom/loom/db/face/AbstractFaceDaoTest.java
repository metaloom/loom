package io.metaloom.loom.db.face;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.db.model.embedding.EmbeddingType;
import io.metaloom.loom.db.model.embedding.FaceOrigin;
import io.metaloom.loom.db.model.user.User;

public abstract class AbstractFaceDaoTest {

	abstract public EmbeddingDao getDao();

	@Test
	public void testCreate() {
		EmbeddingDao dao = getDao();

		float[] embeddingData = new float[] { 0, 0, 0 };
		FaceOrigin origin = null;
		User user = null;
		Binary binary = null;
		Embedding embedding = dao.createEmbedding(user, binary, embeddingData, EmbeddingType.DLIB_FACE_RESNET_v1, 1);
		assertNotNull(embedding.getUuid());
		assertEquals(42L, embedding.getId());
	}
}
