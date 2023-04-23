package io.metaloom.loom.db.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.model.asset.AssetBinaryDao;
import io.metaloom.loom.db.model.asset.AssetDao;
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
	public Lazy<AssetDao> assetDao;

	@Inject
	public Lazy<AssetBinaryDao> assetBinaryDao;

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
	public LoomContentDao contentDao() {
		return contentDao.get();
	}

	@Override
	public AssetDao assetDao() {
		return assetDao.get();
	}

	@Override
	public AssetBinaryDao assetBinaryDao() {
		return assetBinaryDao.get();
	}

	@Override
	public LoomExtensionDao extensionDao() {
		return extensionDao.get();
	}

	@Override
	public LoomWebhookDao webhookDao() {
		return webhookDao.get();
	}

	@Override
	public LoomFieldDao fieldDao() {
		return fieldDao.get();
	}

	@Override
	public LoomUserDao userDao() {
		return userDao.get();
	}

	@Override
	public LoomGroupDao groupDao() {
		return groupDao.get();
	}

	@Override
	public LoomRoleDao roleDao() {
		return roleDao.get();
	}

	@Override
	public LoomModelDao modelDao() {
		return modelDao.get();
	}

	@Override
	public LoomNamespaceDao namespaceDao() {
		return namespaceDao.get();
	}

}
