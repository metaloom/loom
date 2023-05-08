package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.reaction.Reaction;
import io.metaloom.loom.rest.model.reaction.ReactionResponse;

public interface ReactionModelBuilder extends ModelBuilder {

	default ReactionResponse toResponse(Reaction reaction) {
		ReactionResponse response = new ReactionResponse();
		response.setUuid(reaction.getUuid());
		return response;
	}

}
