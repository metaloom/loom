package io.metaloom.loom.db.tag;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class FsTagDaoImpl extends AbstractFSDao implements LoomTagDao {

	@Inject
	public FsTagDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.TAG;
	}

	@Override
	public Maybe<? extends LoomTag> loadTag(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsTagImpl.class);
	}

	@Override
	public void deleteTag(LoomTag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		FilesystemIoHelper.delete(getType(), tag.getUuid());
	}

	@Override
	public Single<? extends LoomTag> createTag(String name, String collection) {
		return Single.fromCallable(() -> {
			LoomTag tag = new FsTagImpl();
			tag.setUuid(UUIDUtil.randomUUID());
			tag.setName(name);
			tag.setCollection(collection);
			return tag;
		});
	}

	@Override
	public void updateTag(LoomTag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		FilesystemIoHelper.store(getType(), tag.getUuid(), tag);
	}

	@Override
	public void storeTag(LoomTag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		FilesystemIoHelper.store(getType(), tag.getUuid(), tag);
	}

}
