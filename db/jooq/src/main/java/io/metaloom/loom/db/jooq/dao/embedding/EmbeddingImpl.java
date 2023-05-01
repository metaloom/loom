package io.metaloom.loom.db.jooq.dao.embedding;

import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.embedding.Embedding;
import io.vertx.core.json.JsonObject;

public class EmbeddingImpl extends AbstractWrappedElement<JooqEmbedding> implements Embedding {

	public EmbeddingImpl(JooqEmbedding delegate) {
		super(delegate);
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public Embedding setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		String data = delegate().getMeta().data();
		return new JsonObject(data);
	}

	@Override
	public Embedding setMeta(JsonObject meta) {
		String json = meta.encode();
		delegate().setMeta(JSONB.jsonbOrNull(json));
		return this;
	}

	@Override
	public Long getEmbeddingId() {
		return delegate().getEmbeddingId();
	}

	@Override
	public Embedding setEmbeddingId(Long id) {
		delegate().setEmbeddingId(id);
		return this;
	}

}
