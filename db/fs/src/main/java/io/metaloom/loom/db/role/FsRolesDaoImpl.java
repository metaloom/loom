package io.metaloom.loom.db.role;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;

public class FsRolesDaoImpl extends AbstractFSDao implements RolesDao {

	protected FSType getType() {
		return FSType.ROLE;
	}

	@Override
	public Role loadRole(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsRoleImpl.class);
	}

	@Override
	public void deleteRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		FilesystemIoHelper.delete(getType(), role.getUuid());
	}

	@Override
	public Role createRole() {
		Role role = new FsRoleImpl();
		role.setUuid(UUIDUtil.randomUUID());
		return role;
	}

	@Override
	public void updateRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		FilesystemIoHelper.store(getType(), role.getUuid(), role);
	}

	@Override
	public void storeRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		FilesystemIoHelper.store(getType(), role.getUuid(), role);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
