package io.metaloom.loom.db.group;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;

public class FsGroupsDaoImpl extends AbstractFSDao implements GroupsDao {

	protected FSType getType() {
		return FSType.GROUP;
	}

	@Override
	public Group loadGroup(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsGroupImpl.class);
	}

	@Override
	public void deleteGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.delete(getType(), group.getUuid());
	}

	@Override
	public Group createGroup() {
		Group group = new FsGroupImpl();
		group.setUuid(UUIDUtil.randomUUID());
		return group;
	}

	@Override
	public void updateGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.store(getType(), group.getUuid(), group);
	}

	@Override
	public void storeGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.store(getType(), group.getUuid(), group);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
