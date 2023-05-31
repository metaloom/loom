package io.metaloom.loom.rest.model.embedding;

import java.util.UUID;

import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.rest.model.annotation.AreaInfo;
import io.vertx.core.json.JsonObject;

public class EmbeddingInfo implements EmbeddingModel<EmbeddingInfo> {

	private UUID uuid;

	private EmbeddingType type;

	private Float[] vector;

	private AreaInfo area;

	private JsonObject meta;

	public UUID getUuid() {
		return uuid;
	}

	public EmbeddingInfo setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	@Override
	public EmbeddingType getType() {
		return type;
	}

	@Override
	public EmbeddingInfo setType(EmbeddingType type) {
		this.type = type;
		return this;
	}

	@Override
	public Float[] getVector() {
		return vector;
	}

	@Override
	public EmbeddingInfo setVector(Float[] vector) {
		this.vector = vector;
		return this;
	}

	@Override
	public AreaInfo getArea() {
		return area;
	}

	@Override
	public EmbeddingInfo setArea(AreaInfo area) {
		this.area = area;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public EmbeddingInfo setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public EmbeddingInfo self() {
		return this;
	}

}
