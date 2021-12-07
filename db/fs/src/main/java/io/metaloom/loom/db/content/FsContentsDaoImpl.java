package io.metaloom.loom.db.content;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.content.ContentDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsContentsDaoImpl extends AbstractFSDao implements ContentDao {

	@Inject
	public FsContentsDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.CONTENT;
	}

	@Override
	public Maybe<? extends Content> loadContent(UUID uuid) {
		return load(uuid, FsContentImpl.class);
	}

	@Override
	public Completable deleteContent(Content content) {
		Objects.requireNonNull(content, "Content must not be null");
		return delete(content.getUuid());
	}

	@Override
	public Single<? extends Content> createContent() {
		Content content = new FsContentImpl();
		content.setUuid(UUIDUtil.randomUUID());
		return store(content);
	}

	@Override
	public Completable updateContent(Content content) {
		Objects.requireNonNull(content, "Content must not be null");
		return store(content).ignoreElement();
	}

	@Override
	public Observable<Tag> loadTags(Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(Content content, Tag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(Content content, Tag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

}
