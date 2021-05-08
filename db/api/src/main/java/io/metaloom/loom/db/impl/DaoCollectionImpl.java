package io.metaloom.loom.db.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.asset.LoomAssetDao;
import io.metaloom.loom.db.content.LoomContentDao;
import io.metaloom.loom.db.extension.LoomExtensionDao;
import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.group.LoomGroupDao;
import io.metaloom.loom.db.model.LoomModelDao;
import io.metaloom.loom.db.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.role.LoomRoleDao;
import io.metaloom.loom.db.user.LoomUserDao;
import io.metaloom.loom.db.webhook.LoomWebhookDao;

@Singleton
public class DaoCollectionImpl implements DaoCollection {

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
	public DaoCollectionImpl() {
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
