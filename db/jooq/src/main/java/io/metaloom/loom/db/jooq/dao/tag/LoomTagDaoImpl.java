package io.metaloom.loom.db.jooq.dao.tag;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTagAssetDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTagContentDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTagDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTagNamespaceDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.content.LoomContent;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.metaloom.loom.db.model.tag.LoomTagDao;

@Singleton
public class LoomTagDaoImpl extends AbstractJooqDao<JooqTagDao> implements LoomTagDao {

	private final JooqTagNamespaceDao tagNamespaceDao;
	private final JooqTagAssetDao tagAssetDao;
	private final JooqTagContentDao tagContentDao;

	@Inject
	public LoomTagDaoImpl(JooqTagNamespaceDao tagNamespaceDao, JooqTagAssetDao tagAssetDao,
		JooqTagContentDao tagContentDao, JooqTagDao tagDao, DSLContext ctx) {
		super(tagDao, ctx);
		this.tagNamespaceDao = tagNamespaceDao;
		this.tagAssetDao = tagAssetDao;
		this.tagContentDao = tagContentDao;
	}

	@Override
	public LoomTag loadTag(UUID uuid) {
		return wrap(dao().findById(uuid));
	}

	@Override
	public void deleteTag(UUID uuid) {
		Objects.requireNonNull(uuid, "Tag uuid must not be null");
		dao().deleteById(uuid);
	}

	// @Override
	// public Single<LoomTag> createTag(String name, String collection) {
	// Tag tag = new Tag();
	// tag.setName(name);
	// tag.setCollection(collection);
	// return insertReturningPrimary(tag).map(pk -> new LoomTagImpl(tag.setUuid(pk)));
	// }
	//
	// @Override
	// public void updateTag(LoomTag tag) {
	// Objects.requireNonNull(tag, "Tag must not be null");
	// Tag jooqTag = unwrap(tag);
	// return update(jooqTag).ignoreElement();
	// }
	//
	// @Override
	// public void tagAsset(LoomTag tag, LoomAsset asset) {
	// TagAsset tagging = new TagAsset(tag.getUuid(), asset.getUuid());
	// return tagAssetDao.insert(tagging).ignoreElement();
	// }
	//
	// @Override
	// public void untagAsset(LoomTag tag, LoomAsset asset) {
	// TagAssetRecord tagging = new TagAssetRecord(tag.getUuid(), asset.getUuid());
	// return tagAssetDao.deleteById(tagging).ignoreElement();
	// }
	//
	// @Override
	// public void tagContent(LoomTag tag, LoomContent content) {
	// TagContent tagging = new TagContent(tag.getUuid(), content.getUuid());
	// return tagContentDao.insert(tagging).ignoreElement();
	// }
	//
	// @Override
	// public void untagContent(LoomTag tag, LoomContent content) {
	// TagContentRecord tagging = new TagContentRecord(tag.getUuid(), content.getUuid());
	// return tagContentDao.deleteById(tagging).ignoreElement();
	// }
	//
	// @Override
	// public void tagNamespace(LoomTag tag, LoomNamespace namespace) {
	// TagNamespace tagging = new TagNamespace(tag.getUuid(), namespace.getUuid());
	// return tagNamespaceDao.insert(tagging).ignoreElement();
	// }
	//
	// @Override
	// public void untagNamespace(LoomTag tag, LoomNamespace namespace) {
	// TagNamespaceRecord tagging = new TagNamespaceRecord(tag.getUuid(), namespace.getUuid());
	// return tagNamespaceDao.deleteById(tagging).ignoreElement();
	// }

	@Override
	public LoomTag createTag(String name, String collection, Consumer<LoomTag> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTag(LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void tagNamespace(LoomTag tag, LoomNamespace namespace) {
		// TODO Auto-generated method stub
	}

	@Override
	public void untagNamespace(LoomTag tag, LoomNamespace namespace) {
		// TODO Auto-generated method stub
	}

	@Override
	public void tagAsset(LoomTag tag, Asset asset) {
		// TODO Auto-generated method stub
	}

	@Override
	public void untagAsset(LoomTag tag, Asset asset) {
		// TODO Auto-generated method stub
	}

	@Override
	public void tagContent(LoomTag tag, LoomContent content) {
		// TODO Auto-generated method stub
	}

	@Override
	public void untagContent(LoomTag tag, LoomContent content) {
		// TODO Auto-generated method stub
	}
}
