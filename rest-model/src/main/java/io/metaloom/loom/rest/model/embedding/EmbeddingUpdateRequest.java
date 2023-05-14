package io.metaloom.loom.rest.model.embedding;

import java.util.UUID;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.annotation.AreaInfo;
import io.vertx.core.json.JsonObject;

public class EmbeddingUpdateRequest implements MetaModel<EmbeddingUpdateRequest>, RestRequestModel {

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

	public EmbeddingUpdateRequest setId(Long id) {
		this.id = id;
		return this;
	}

	public String getSource() {
		return source;
	}

	public EmbeddingUpdateRequest setSource(String source) {
		this.source = source;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public EmbeddingUpdateRequest setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	public AreaInfo getArea() {
		return area;
	}

	public EmbeddingUpdateRequest setArea(AreaInfo area) {
		this.area = area;
		return this;
	}

	public EmbeddingType getType() {
		return type;
	}

	public EmbeddingUpdateRequest setType(EmbeddingType type) {
		this.type = type;
		return this;
	}

	@Override
	public EmbeddingUpdateRequest self() {
		return this;
	}

	public Float[] getData() {
		return data;
	}

	public EmbeddingUpdateRequest setData(Float[] data) {
		this.data = data;
		return this;
	}

	public UUID getAssetUuid() {
		return assetUuid;
	}

	public EmbeddingUpdateRequest setAssetUuid(UUID assetUuid) {
		this.assetUuid = assetUuid;
		return this;
	}

}
