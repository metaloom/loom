package io.metaloom.loom.db.jooq.dao.tag;

import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqTag;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.tag.TagDao;

@Singleton
public class TagDaoImpl extends AbstractJooqDao<Tag> implements TagDao {

	@Inject
	public TagDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqTag.TAG;
	}

	@Override
	protected Class<? extends Tag> getPojoClass() {
		return TagImpl.class;
	}

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
	public Tag createTag(String name, String collection, Consumer<Tag> modifier) {
		Tag tag = new TagImpl();
		tag.setName(name);
		if (modifier != null) {
			modifier.accept(tag);
		}
		return tag;
	}

	@Override
	public void tagAsset(Tag tag, Asset asset) {
		// TODO Auto-generated method stub
	}

	@Override
	public void untagAsset(Tag tag, Asset asset) {
		// TODO Auto-generated method stub
	}

}
