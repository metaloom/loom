package io.metaloom.loom.db.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.content.LoomContentDao;
import io.metaloom.loom.db.model.extension.LoomExtensionDao;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.model.LoomModelDao;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.model.role.LoomRoleDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.db.model.webhook.LoomWebhookDao;

@Singleton
public class LoomDaoCollectionImpl implements LoomDaoCollection {

	@Inject
	public Lazy<LoomContentDao> contentDao;

	@Inject
	public Lazy<LoomFieldDao> fieldDao;

	@Inject
	public Lazy<LoomUserDao> userDao;

	@Inject
	public Lazy<LoomRoleDao> roleDao;

	@Inject
	public Lazy<LoomGroupDao> groupDao;

	@Inject
	public Lazy<LoomAssetDao> assetDao;

	@Inject
	public Lazy<LoomNamespaceDao> namespaceDao;

	@Inject
	public Lazy<LoomModelDao> modelDao;

	@Inject
	public Lazy<LoomExtensionDao> extensionDao;

	@Inject
	public Lazy<LoomWebhookDao> webhookDao;

	@Inject
	public LoomDaoCollectionImpl() {
	}

	@Override
	public LoomContentDao getContentDao() {
		return contentDao.get();
	}

	@Override
	public LoomAssetDao getAssetDao() {
		return assetDao.get();
	}

	@Override
	public LoomExtensionDao getExtensionDao() {
		return extensionDao.get();
	}

	@Override
	public LoomWebhookDao getWebhookDao() {
		return webhookDao.get();
	}

	@Override
	public LoomFieldDao getFieldDao() {
		return fieldDao.get();
	}

	@Override
	public LoomUserDao getUserDao() {
		return userDao.get();
	}

	@Override
	public LoomGroupDao getGroupDao() {
		return groupDao.get();
	}

	@Override
	public LoomRoleDao getRoleDao() {
		return roleDao.get();
	}

	@Override
	public LoomModelDao getModelDao() {
		return modelDao.get();
	}

	@Override
	public LoomNamespaceDao getNamespaceDao() {
		return namespaceDao.get();
	}

}
