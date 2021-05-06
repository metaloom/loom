package io.metaloom.loom.db.content;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Observable;

@Singleton
public class FsContentsDaoImpl extends AbstractFSDao implements ContentDao {

	@Inject
	public FsContentsDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.CONTENT;
	}

	@Override
	public Maybe<? extends Content> loadContent(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsContentImpl.class);
	}

	@Override
	public void deleteContent(Content content) {
		Objects.requireNonNull(content, "Content must not be null");
		FilesystemIoHelper.delete(getType(), content.getUuid());
	}

	@Override
	public Content createContent() {
		Content content = new FsContentImpl();
		content.setUuid(UUIDUtil.randomUUID());
		return content;
	}

	@Override
	public void updateContent(Content content) {
		Objects.requireNonNull(content, "Content must not be null");
		FilesystemIoHelper.store(getType(), content.getUuid(), content);
	}

	@Override
	public void storeContent(Content content) {
		Objects.requireNonNull(content, "Content must not be null");
		FilesystemIoHelper.store(getType(), content.getUuid(), content);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

	@Override
	public Observable<Tag> loadTags(Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Content content, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(Content content, Tag tag) {
		// TODO Auto-generated method stub
	}

	
}
