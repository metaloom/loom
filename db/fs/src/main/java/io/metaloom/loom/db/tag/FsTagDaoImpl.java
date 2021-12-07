package io.metaloom.loom.db.tag;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.tag.TagDao;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsTagDaoImpl extends AbstractFSDao implements TagDao {

	@Inject
	public FsTagDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.TAG;
	}

	@Override
	public Maybe<? extends Tag> loadTag(UUID uuid) {
		return load(uuid, FsTagImpl.class);
	}

	@Override
	public Completable deleteTag(UUID uuid) {
		Objects.requireNonNull(uuid, "Tag must not be null");
		return delete(uuid);
	}

	@Override
	public Single<? extends Tag> createTag(String name, String collection) {
		return Single.fromCallable(() -> {
			Tag tag = new FsTagImpl();
			tag.setUuid(UUIDUtil.randomUUID());
			tag.setName(name);
			tag.setCollection(collection);
			return tag;
		});
	}

	@Override
	public Completable updateTag(Tag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		return store(tag).ignoreElement();
	}

	@Override
	public Completable tagAsset(Tag tag, Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagAsset(Tag tag, Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable tagContent(Tag tag, Content asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagContent(Tag tag, Content asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable tagNamespace(Tag tag, Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagNamespace(Tag tag, Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

}
