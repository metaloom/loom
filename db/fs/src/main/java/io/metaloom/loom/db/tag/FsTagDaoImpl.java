package io.metaloom.loom.db.tag;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.asset.LoomAsset;
import io.metaloom.loom.db.content.LoomContent;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.namespace.LoomNamespace;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsTagDaoImpl extends AbstractFSDao implements LoomTagDao {

	@Inject
	public FsTagDaoImpl(LoomDaoCollection daos, Vertx rxVertx) {
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
	public Completable deleteTag(UUID uuid) {
		Objects.requireNonNull(uuid, "Tag must not be null");
		return delete(uuid);
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

	@Override
	public Completable tagAsset(LoomTag tag, LoomAsset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagAsset(LoomTag tag, LoomAsset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable tagContent(LoomTag tag, LoomContent asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagContent(LoomTag tag, LoomContent asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable tagNamespace(LoomTag tag, LoomNamespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagNamespace(LoomTag tag, LoomNamespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

}
