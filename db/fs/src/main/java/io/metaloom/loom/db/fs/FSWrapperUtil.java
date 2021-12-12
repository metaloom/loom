package io.metaloom.loom.db.fs;

import io.metaloom.loom.db.fs.dao.group.GroupImpl;
import io.metaloom.loom.db.fs.dao.role.FsRoleImpl;
import io.metaloom.loom.db.fs.dao.user.FsUserImpl;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.LoomUser;

public final class FSWrapperUtil {

	private FSWrapperUtil() {
	}

	public static FsUserImpl toFs(LoomUser user) {
		if (user instanceof FsUserImpl) {
			return (FsUserImpl) user;
		} else {
			throw new RuntimeException("User is not a filesystem user");
		}
	}

	public static GroupImpl toFs(Group group) {
		if (group instanceof GroupImpl) {
			return (GroupImpl) group;
		} else {
			throw new RuntimeException("Group is not a filesystem group");
		}
	}

	public static FsRoleImpl toFs(Role role) {
		if (role instanceof FsRoleImpl) {
			return (FsRoleImpl) role;
		} else {
			throw new RuntimeException("Role is not a filesystem role");
		}
	}
}
