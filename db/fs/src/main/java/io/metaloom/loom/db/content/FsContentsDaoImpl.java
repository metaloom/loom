package io.metaloom.loom.db.content;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.tag.LoomTag;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsContentsDaoImpl extends AbstractFSDao implements LoomContentDao {

	@Inject
	public FsContentsDaoImpl(LoomDaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.CONTENT;
	}

	@Override
	public Maybe<? extends LoomContent> loadContent(UUID uuid) {
		return load(uuid, FsContentImpl.class);
	}

	@Override
	public Completable deleteContent(LoomContent content) {
		Objects.requireNonNull(content, "Content must not be null");
		return delete(content.getUuid());
	}

	@Override
	public Single<? extends LoomContent> createContent() {
		LoomContent content = new FsContentImpl();
		content.setUuid(UUIDUtil.randomUUID());
		return store(content);
	}

	@Override
	public Completable updateContent(LoomContent content) {
		Objects.requireNonNull(content, "Content must not be null");
		return store(content).ignoreElement();
	}

	@Override
	public Observable<LoomTag> loadTags(LoomContent content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(LoomContent content, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(LoomContent content, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

}
