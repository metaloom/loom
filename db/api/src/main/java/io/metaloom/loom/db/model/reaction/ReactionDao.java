package io.metaloom.loom.db.model.reaction;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.AssetId;
import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.model.user.User;

public interface ReactionDao extends CRUDDao<Reaction> {

	default Reaction createReaction(User user, String type) {
		return createReaction(user.getUuid(), type);
	}

	Reaction createReaction(UUID userUuid, String type);

	Reaction createAssetReaction(UUID userUuid, AssetId assetId, String type);

}
