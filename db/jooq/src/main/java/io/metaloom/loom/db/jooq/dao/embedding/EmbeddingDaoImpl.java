package io.metaloom.loom.db.jooq.dao.embedding;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.lang3.ArrayUtils;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqEmbedding;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.db.model.embedding.EmbeddingType;

@Singleton
public class EmbeddingDaoImpl extends AbstractJooqDao<Embedding> implements EmbeddingDao {

	@Inject
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
	public Embedding createEmbedding(UUID userUuid, UUID binaryUuid, float[] data, EmbeddingType type, long id) {
		Embedding embedding = new EmbeddingImpl();
		embedding.setData(ArrayUtils.toObject(data));
		embedding.setType(type);
		embedding.setId(id);
		embedding.setBinaryUuid(binaryUuid);
		setCreatorEditor(embedding, userUuid);
		return embedding;
	}

	@Override
	public void store(Embedding element) {
		TableRecord<?> reco = ctx().newRecord(getTable(), element);
		if (element.getUuid() == null) {
			reco.reset("uuid");
		}
		UUID uuid = ctx().insertInto(getTable())
			.set(reco)
			.returning(getTable().field("uuid", UUID.class))
			.fetchOne("uuid", UUID.class);
		if (uuid == null) {
			throw new RuntimeException("Key null!!");
		}
		element.setUuid(uuid);
		System.out.println("Element: " + element);
	}

}
