package io.metaloom.loom.db.jooq.dao.face;

import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.jooq.tables.pojos.JooqFace;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.face.Face;
import io.vertx.core.json.JsonObject;

public class FaceImpl extends AbstractWrappedElement<JooqFace> implements Face {

	public FaceImpl(JooqFace delegate) {
		super(delegate);
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public Face setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		String data = delegate().getMeta().data();
		return new JsonObject(data);
	}

	@Override
	public Face setMeta(JsonObject meta) {
		String json = meta.encode();
		delegate().setMeta(JSONB.jsonbOrNull(json));
		return this;
	}

	@Override
	public Integer getFaceNr() {
		return delegate().getFaceNr();
	}

}
