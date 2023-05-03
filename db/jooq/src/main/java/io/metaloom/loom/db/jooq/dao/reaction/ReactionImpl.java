package io.metaloom.loom.db.jooq.dao.reaction;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.reaction.Reaction;

public class ReactionImpl extends AbstractEditableElement<Reaction> implements Reaction {

	private String type;

	@Override
	public String getType() {
		return type;
	}

	@Override
	public ReactionImpl setType(String type) {
		this.type = type;
		return this;
	}
}
