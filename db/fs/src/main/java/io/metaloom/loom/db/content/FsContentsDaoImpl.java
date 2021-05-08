package io.metaloom.loom.db.content;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.db.tag.LoomTag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Observable;

@Singleton
public class FsContentsDaoImpl extends AbstractFSDao implements LoomContentDao {

	@Inject
	public FsContentsDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.CONTENT;
	}

	@Override
	public Maybe<? extends LoomContent> loadContent(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsContentImpl.class);
	}

	@Override
	public void deleteContent(LoomContent content) {
		Objects.requireNonNull(content, "Content must not be null");
		FilesystemIoHelper.delete(getType(), content.getUuid());
	}

	@Override
	public LoomContent createContent() {
		LoomContent content = new FsContentImpl();
		content.setUuid(UUIDUtil.randomUUID());
		return content;
	}

	@Override
	public void updateContent(LoomContent content) {
		Objects.requireNonNull(content, "Content must not be null");
		FilesystemIoHelper.store(getType(), content.getUuid(), content);
	}

	@Override
	public void storeContent(LoomContent content) {
		Objects.requireNonNull(content, "Content must not be null");
		FilesystemIoHelper.store(getType(), content.getUuid(), content);
	}

	@Override
	public Observable<LoomTag> loadTags(LoomContent content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(LoomContent content, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(LoomContent content, LoomTag tag) {
		// TODO Auto-generated method stub
	}

}
