package io.metaloom.loom.rest.model.embedding.attachment;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class EmbeddingAttachmentResponse extends AbstractCreatorEditorRestResponse<EmbeddingAttachmentResponse>
	implements EmbeddingAttachmentModel<EmbeddingAttachmentResponse> {

	@Override
	public EmbeddingAttachmentResponse self() {
		return this;
	}

}
