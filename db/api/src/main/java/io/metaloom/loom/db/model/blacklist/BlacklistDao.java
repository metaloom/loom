package io.metaloom.loom.db.model.blacklist;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.binary.Binary;
import io.metaloom.loom.db.model.user.User;

public interface BlacklistDao extends CRUDDao<Blacklist> {

	default Blacklist createBlacklist(User user, Binary binary, String name) {
		return createBlacklist(user.getUuid(), binary.getUuid(), name);
	}

	Blacklist createBlacklist(UUID userUuid, UUID binaryUUID, String name);

}
