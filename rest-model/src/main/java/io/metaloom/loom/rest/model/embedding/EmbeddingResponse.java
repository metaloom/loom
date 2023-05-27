package io.metaloom.loom.rest.model.embedding;

import io.metaloom.loom.rest.model.annotation.AreaInfo;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class EmbeddingResponse extends AbstractCreatorEditorRestResponse<EmbeddingResponse> implements EmbeddingModel<EmbeddingResponse> {

	private AreaInfo area;

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
