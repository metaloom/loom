package io.metaloom.loom.db.model.blacklist;

import io.metaloom.loom.db.CRUDDao;

public interface BlacklistDao extends CRUDDao<Blacklist> {

	Blacklist createBlacklist(String name);

}
