package io.metaloom.loom.db.jooq.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.db.CRUDDaoTestcases;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.db.model.user.User;

public class EmbeddingDaoTest extends AbstractJooqTest implements CRUDDaoTestcases<EmbeddingDao, Embedding> {

	@Override
	public EmbeddingDao getDao() {
		return embeddingDao();
	}

	@Override
	public Embedding createElement(User user, int i) {
		return getDao().createEmbedding(user, asset(), VECTOR_DATA, EmbeddingType.DLIB_FACE_RESNET_v1, i);
	}

	@Override
	public void assertCreate(Embedding createdElement) {
		assertEquals(asset().getUuid(), createdElement.getAssetUuid());
		assertEquals(EmbeddingType.DLIB_FACE_RESNET_v1, createdElement.getType());
		assertEquals(0, createdElement.getId());
	}

	@Override
	public void assertUpdate(Embedding updatedElement) {
		assertEquals(42, updatedElement.getId());
	}

	@Override
	public void updateElement(Embedding element) {
		element.setId(42);
	}

}
