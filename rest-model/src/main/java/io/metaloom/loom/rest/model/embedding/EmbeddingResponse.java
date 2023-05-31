package io.metaloom.loom.rest.model.embedding;

import io.metaloom.loom.api.embedding.EmbeddingType;
import io.metaloom.loom.rest.model.annotation.AreaInfo;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class EmbeddingResponse extends AbstractCreatorEditorRestResponse<EmbeddingResponse> implements EmbeddingModel<EmbeddingResponse> {

	private EmbeddingType type;

	private Float[] vector;

	private AreaInfo area;

	@Override
	public EmbeddingType getType() {
		return type;
	}

	@Override
	public EmbeddingResponse setType(EmbeddingType type) {
		this.type = type;
		return this;
	}

	@Override
	public Float[] getVector() {
		return vector;
	}

	@Override
	public EmbeddingResponse setVector(Float[] vector) {
		this.vector = vector;
		return this;
	}

	@Override
	public AreaInfo getArea() {
		return area;
	}

	@Override
	public EmbeddingResponse setArea(AreaInfo area) {
		this.area = area;
		return this;
	}

	@Override
	public EmbeddingResponse self() {
		return this;
	}

}
