package io.metaloom.loom.db.model.reaction;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetLocation;
import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.model.user.User;

public interface ReactionDao extends CRUDDao<Reaction> {

	default Reaction createReaction(User user, String type) {
		return createReaction(user.getUuid(), type);
	}

	Reaction createReaction(UUID userUuid, String type);

	void link(Reaction reaction, Asset binary);

	void unlink(Reaction reaction, Asset binary);

	void link(Reaction reaction, AssetLocation asset);

	void unlink(Reaction reaction, AssetLocation asset);

	void link(Reaction reaction, Task task);

	void unlink(Reaction reaction, Task task);

}
