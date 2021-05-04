package io.metaloom.loom.db.group;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface GroupsDao extends LoomDao {

	Group createGroup();

	void deleteGroup(Group group);

	void updateGroup(Group group);

	Maybe<? extends Group> loadGroup(UUID uuid);

	void storeGroup(Group group);

}
