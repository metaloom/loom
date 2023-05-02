package io.metaloom.loom.db.jooq.dao.embedding;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqEmbedding;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.db.model.embedding.FaceOrigin;

public class EmbeddingDaoImpl extends AbstractJooqDao<Embedding> implements EmbeddingDao {

	public EmbeddingDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqEmbedding.EMBEDDING;
	}

	@Override
	protected Class<? extends Embedding> getPojoClass() {
		return EmbeddingImpl.class;
	}

	@Override
	public Embedding createEmbedding(String source, float[] embeddings, FaceOrigin origin) {
		Embedding embedding = new EmbeddingImpl();
		embedding.setEmbeddingId(Long.valueOf(origin.faceNr()));
		return embedding;
	}

}
