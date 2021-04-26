package io.metaloom.loom.db.group;

import java.io.IOException;
import java.util.UUID;

public interface GroupsDao {

	Group createGroup();

	void deleteGroup(Group group);

	void updateGroup(Group group);

	Group loadGroup(UUID uuid);

	Group storeRole(Group group);

	void clear() throws IOException;
}
