package io.metaloom.loom.db.tag;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class FsTagsDaoImpl extends AbstractFSDao implements TagsDao {

	protected FSType getType() {
		return FSType.TAG;
	}

	@Override
	public Maybe<? extends Tag> loadTag(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsTagImpl.class);
	}

	@Override
	public void deleteTag(Tag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		FilesystemIoHelper.delete(getType(), tag.getUuid());
	}

	@Override
	public Single<Tag> createTag() {
		Tag tag = new FsTagImpl();
		tag.setUuid(UUIDUtil.randomUUID());
		return Single.just(tag);
	}

	@Override
	public void updateTag(Tag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		FilesystemIoHelper.store(getType(), tag.getUuid(), tag);
	}

	@Override
	public void storeTag(Tag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		FilesystemIoHelper.store(getType(), tag.getUuid(), tag);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
