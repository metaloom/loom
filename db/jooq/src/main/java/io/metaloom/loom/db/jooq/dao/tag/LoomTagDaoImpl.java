package io.metaloom.loom.db.jooq.dao.tag;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrapMaybe;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.TagAssetDao;
import io.metaloom.loom.db.jooq.tables.daos.TagContentDao;
import io.metaloom.loom.db.jooq.tables.daos.TagDao;
import io.metaloom.loom.db.jooq.tables.daos.TagNamespaceDao;
import io.metaloom.loom.db.jooq.tables.pojos.Tag;
import io.metaloom.loom.db.jooq.tables.pojos.TagAsset;
import io.metaloom.loom.db.jooq.tables.pojos.TagContent;
import io.metaloom.loom.db.jooq.tables.pojos.TagNamespace;
import io.metaloom.loom.db.jooq.tables.records.TagAssetRecord;
import io.metaloom.loom.db.jooq.tables.records.TagContentRecord;
import io.metaloom.loom.db.jooq.tables.records.TagNamespaceRecord;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.content.LoomContent;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.metaloom.loom.db.model.tag.LoomTagDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class LoomTagDaoImpl extends AbstractDao implements LoomTagDao {

	private final TagNamespaceDao tagNamespaceDao;
	private final TagAssetDao tagAssetDao;
	private final TagContentDao tagContentDao;
	private final TagDao tagDao;

	@Inject
	public LoomTagDaoImpl(TagNamespaceDao tagNamespaceDao, TagAssetDao tagAssetDao,
		TagContentDao tagContentDao, TagDao tagDao, DSLContext ctx) {
		super(ctx);
		this.tagNamespaceDao = tagNamespaceDao;
		this.tagAssetDao = tagAssetDao;
		this.tagContentDao = tagContentDao;
		this.tagDao = tagDao;
	}

	@Override
	public Maybe<? extends LoomTag> loadTag(UUID uuid) {
		return wrapMaybe(tagDao.findById(uuid), LoomTagImpl.class);
	}

	@Override
	public Completable deleteTag(UUID uuid) {
		Objects.requireNonNull(uuid, "Tag uuid must not be null");
		return Completable.fromAction(() -> {
			tagDao.deleteById(uuid);
		});
	}

//	@Override
//	public Single<LoomTag> createTag(String name, String collection) {
//		Tag tag = new Tag();
//		tag.setName(name);
//		tag.setCollection(collection);
//		return insertReturningPrimary(tag).map(pk -> new LoomTagImpl(tag.setUuid(pk)));
//	}
//
//	@Override
//	public Completable updateTag(LoomTag tag) {
//		Objects.requireNonNull(tag, "Tag must not be null");
//		Tag jooqTag = unwrap(tag);
//		return update(jooqTag).ignoreElement();
//	}
//
//	@Override
//	public Completable tagAsset(LoomTag tag, LoomAsset asset) {
//		TagAsset tagging = new TagAsset(tag.getUuid(), asset.getUuid());
//		return tagAssetDao.insert(tagging).ignoreElement();
//	}
//
//	@Override
//	public Completable untagAsset(LoomTag tag, LoomAsset asset) {
//		TagAssetRecord tagging = new TagAssetRecord(tag.getUuid(), asset.getUuid());
//		return tagAssetDao.deleteById(tagging).ignoreElement();
//	}
//
//	@Override
//	public Completable tagContent(LoomTag tag, LoomContent content) {
//		TagContent tagging = new TagContent(tag.getUuid(), content.getUuid());
//		return tagContentDao.insert(tagging).ignoreElement();
//	}
//
//	@Override
//	public Completable untagContent(LoomTag tag, LoomContent content) {
//		TagContentRecord tagging = new TagContentRecord(tag.getUuid(), content.getUuid());
//		return tagContentDao.deleteById(tagging).ignoreElement();
//	}
//
//	@Override
//	public Completable tagNamespace(LoomTag tag, LoomNamespace namespace) {
//		TagNamespace tagging = new TagNamespace(tag.getUuid(), namespace.getUuid());
//		return tagNamespaceDao.insert(tagging).ignoreElement();
//	}
//
//	@Override
//	public Completable untagNamespace(LoomTag tag, LoomNamespace namespace) {
//		TagNamespaceRecord tagging = new TagNamespaceRecord(tag.getUuid(), namespace.getUuid());
//		return tagNamespaceDao.deleteById(tagging).ignoreElement();
//	}

	@Override
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public Single<? extends LoomTag> createTag(String name, String collection, Consumer<LoomTag> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateTag(LoomTag tag) {
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
	public Completable tagContent(LoomTag tag, LoomContent content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagContent(LoomTag tag, LoomContent content) {
		// TODO Auto-generated method stub
		return null;
	}
}
