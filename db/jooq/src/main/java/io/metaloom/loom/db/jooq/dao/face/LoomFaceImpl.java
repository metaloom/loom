package io.metaloom.loom.db.jooq.dao.face;

import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.jooq.tables.pojos.Face;
import io.metaloom.loom.db.model.face.LoomFace;
import io.vertx.core.json.JsonObject;

public class LoomFaceImpl implements LoomFace {

	private Face delegate;

	public LoomFaceImpl(Face face) {
		this.delegate = face;
	}

	@Override
	public UUID getUuid() {
		return delegate.getUuid();
	}

	@Override
	public LoomFace setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		String data = delegate.getMeta().data();
		return new JsonObject(data);
	}

	@Override
	public LoomFace setMeta(JsonObject meta) {
		String json = meta.encode();
		delegate.setMeta(JSONB.jsonbOrNull(json));
		return this;
	}

	@Override
	public Integer getFaceNr() {
		return delegate.getFaceNr();
	}

}
