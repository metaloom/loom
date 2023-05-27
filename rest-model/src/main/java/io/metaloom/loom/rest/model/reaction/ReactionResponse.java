package io.metaloom.loom.rest.model.reaction;

import io.metaloom.loom.rest.model.common.AbstractResponse;
import io.vertx.core.json.JsonObject;

public class ReactionResponse extends AbstractResponse<ReactionResponse> implements ReactionModel<ReactionResponse> {

	private JsonObject meta;

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public ReactionResponse setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public ReactionResponse self() {
		return this;
	}

}
