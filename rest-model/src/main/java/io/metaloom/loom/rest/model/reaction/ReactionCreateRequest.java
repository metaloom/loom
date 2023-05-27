package io.metaloom.loom.rest.model.reaction;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class ReactionCreateRequest extends AbstractMetaModel<ReactionCreateRequest>
	implements RestRequestModel, ReactionModel<ReactionCreateRequest> {

	@Override
	public ReactionCreateRequest self() {
		return this;
	}

}
