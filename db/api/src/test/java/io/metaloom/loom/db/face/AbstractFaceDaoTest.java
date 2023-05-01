package io.metaloom.loom.db.face;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.db.model.embedding.FaceOrigin;

public abstract class AbstractFaceDaoTest {

	abstract public EmbeddingDao getDao();

	@AfterEach
	@BeforeEach
	public void clearPersistence() throws IOException {
		getDao().clear();
	}
	
	@Test
	public void testCreate() {
		EmbeddingDao dao = getDao();

		float[] embeddingData = new float[] {0,0,0};
		FaceOrigin origin = null;
		Embedding embedding = dao.createEmbedding("source", embeddingData, origin );
		assertNotNull(embedding.getUuid());
		assertEquals(42L, embedding.getEmbeddingId().longValue());
	}
}
