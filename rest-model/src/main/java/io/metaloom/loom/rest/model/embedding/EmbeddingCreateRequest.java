package io.metaloom.loom.rest.model.embedding;

import java.util.UUID;

import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.annotation.AreaInfo;
import io.vertx.core.json.JsonObject;

public class EmbeddingCreateRequest implements RestRequestModel, EmbeddingModel<EmbeddingCreateRequest> {

	private Long id;

	private String source;
	private JsonObject meta;
	private AreaInfo area;

	private EmbeddingType type;

	private Float[] data;

	private UUID assetUuid;

	public Long getId() {
		return id;
	}

	public EmbeddingCreateRequest setId(Long id) {
		this.id = id;
		return this;
	}

	public String getSource() {
		return source;
	}

	public EmbeddingCreateRequest setSource(String source) {
		this.source = source;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public EmbeddingCreateRequest setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public AreaInfo getArea() {
		return area;
	}

	@Override
	public EmbeddingCreateRequest setArea(AreaInfo area) {
		this.area = area;
		return this;
	}

	public EmbeddingType getType() {
		return type;
	}

	public EmbeddingCreateRequest setType(EmbeddingType type) {
		this.type = type;
		return this;
	}

	public Float[] getData() {
		return data;
	}

	public EmbeddingCreateRequest setData(Float[] data) {
		this.data = data;
		return this;
	}

	public UUID getAssetUuid() {
		return assetUuid;
	}

	public EmbeddingCreateRequest setAssetUuid(UUID assetUuid) {
		this.assetUuid = assetUuid;
		return this;
	}


	@Override
	public EmbeddingCreateRequest self() {
		return this;
	}

}
