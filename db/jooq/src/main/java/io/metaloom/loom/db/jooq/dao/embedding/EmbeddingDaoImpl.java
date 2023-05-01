package io.metaloom.loom.db.jooq.dao.embedding;

import java.util.UUID;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqEmbeddingDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.db.model.embedding.FaceOrigin;

public class EmbeddingDaoImpl extends AbstractJooqDao<JooqEmbeddingDao> implements EmbeddingDao {

	public EmbeddingDaoImpl(JooqEmbeddingDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Embedding createEmbedding(String source, float[] embeddings, FaceOrigin origin) {
		JooqEmbedding embedding = new JooqEmbedding();
		embedding.setEmbeddingId(Long.valueOf(origin.faceNr()));
		return new EmbeddingImpl(embedding);
	}

	@Override
	public void deleteFace(UUID uuid) {
		dao().deleteById(uuid);
	}

}
