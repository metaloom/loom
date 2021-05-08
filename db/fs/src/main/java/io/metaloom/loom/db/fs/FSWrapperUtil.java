package io.metaloom.loom.db.fs;

import io.metaloom.loom.db.group.FsGroupImpl;
import io.metaloom.loom.db.group.LoomGroup;
import io.metaloom.loom.db.role.FsRoleImpl;
import io.metaloom.loom.db.role.LoomRole;
import io.metaloom.loom.db.user.FsUserImpl;
import io.metaloom.loom.db.user.LoomUser;

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

	public static FsGroupImpl toFs(LoomGroup group) {
		if (group instanceof FsGroupImpl) {
			return (FsGroupImpl) group;
		} else {
			throw new RuntimeException("Group is not a filesystem group");
		}
	}

	public static FsRoleImpl toFs(LoomRole role) {
		if (role instanceof FsRoleImpl) {
			return (FsRoleImpl) role;
		} else {
			throw new RuntimeException("Role is not a filesystem role");
		}
	}
}
