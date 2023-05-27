package io.metaloom.loom.rest.model.reaction;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class ReactionUpdateRequest extends AbstractMetaModel<ReactionUpdateRequest>
	implements RestRequestModel, ReactionModel<ReactionUpdateRequest> {

	@Override
	public ReactionUpdateRequest self() {
		return this;
	}

}
