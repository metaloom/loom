package io.metaloom.loom.db.group;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface GroupsDao extends LoomDao {

	Group createGroup();

	void deleteGroup(Group group);

	void updateGroup(Group group);

	Group loadGroup(UUID uuid);

	void storeGroup(Group group);

}
