package io.metaloom.loom.db.tag;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsTagDaoImpl extends AbstractFSDao implements LoomTagDao {

	@Inject
	public FsTagDaoImpl(DaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.TAG;
	}

	@Override
	public Maybe<? extends LoomTag> loadTag(UUID uuid) {
		return load(uuid, FsTagImpl.class);
	}

	@Override
	public Completable deleteTag(LoomTag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		return delete(tag.getUuid());
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
	public Completable updateTag(LoomTag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		return store(tag).ignoreElement();
	}

}
