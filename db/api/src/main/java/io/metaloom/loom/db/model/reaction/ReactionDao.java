package io.metaloom.loom.db.model.reaction;

import io.metaloom.loom.db.CRUDDao;

public interface ReactionDao extends CRUDDao<Reaction> {

	Reaction createReaction(String type);

}
