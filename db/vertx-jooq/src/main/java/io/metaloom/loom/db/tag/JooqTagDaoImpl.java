package io.metaloom.loom.db.tag;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.asset.LoomAsset;
import io.metaloom.loom.db.content.LoomContent;
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
import io.metaloom.loom.db.namespace.LoomNamespace;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqTagDaoImpl extends TagDao implements LoomTagDao {

	private final TagNamespaceDao tagNamespaceDao;
	private final TagAssetDao tagAssetDao;
	private final TagContentDao tagContentDao;

	@Inject
	public JooqTagDaoImpl(Configuration configuration, SqlClient rxSqlClient, TagNamespaceDao tagNamespaceDao, TagAssetDao tagAssetDao,
		TagContentDao tagContentDao) {
		super(configuration, rxSqlClient);
		this.tagNamespaceDao = tagNamespaceDao;
		this.tagAssetDao = tagAssetDao;
		this.tagContentDao = tagContentDao;
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public Maybe<? extends LoomTag> loadTag(UUID uuid) {
		return wrap(findOneById(uuid), JooqTagImpl.class);
	}

	@Override
	public Completable deleteTag(UUID uuid) {
		Objects.requireNonNull(uuid, "Tag uuid must not be null");
		return deleteById(uuid).ignoreElement();
	}

	@Override
	public Single<LoomTag> createTag(String name, String collection) {
		Tag tag = new Tag();
		tag.setName(name);
		tag.setCollection(collection);
		return insertReturningPrimary(tag).map(pk -> new JooqTagImpl(tag.setUuid(pk)));
	}

	@Override
	public Completable updateTag(LoomTag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		Tag jooqTag = unwrap(tag);
		return update(jooqTag).ignoreElement();
	}

	@Override
	public Completable tagAsset(LoomTag tag, LoomAsset asset) {
		TagAsset tagging = new TagAsset(tag.getUuid(), asset.getUuid());
		return tagAssetDao.insert(tagging).ignoreElement();
	}

	@Override
	public Completable untagAsset(LoomTag tag, LoomAsset asset) {
		TagAssetRecord tagging = new TagAssetRecord(tag.getUuid(), asset.getUuid());
		return tagAssetDao.deleteById(tagging).ignoreElement();
	}

	@Override
	public Completable tagContent(LoomTag tag, LoomContent content) {
		TagContent tagging = new TagContent(tag.getUuid(), content.getUuid());
		return tagContentDao.insert(tagging).ignoreElement();
	}

	@Override
	public Completable untagContent(LoomTag tag, LoomContent content) {
		TagContentRecord tagging = new TagContentRecord(tag.getUuid(), content.getUuid());
		return tagContentDao.deleteById(tagging).ignoreElement();
	}

	@Override
	public Completable tagNamespace(LoomTag tag, LoomNamespace namespace) {
		TagNamespace tagging = new TagNamespace(tag.getUuid(), namespace.getUuid());
		return tagNamespaceDao.insert(tagging).ignoreElement();
	}

	@Override
	public Completable untagNamespace(LoomTag tag, LoomNamespace namespace) {
		TagNamespaceRecord tagging = new TagNamespaceRecord(tag.getUuid(), namespace.getUuid());
		return tagNamespaceDao.deleteById(tagging).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
