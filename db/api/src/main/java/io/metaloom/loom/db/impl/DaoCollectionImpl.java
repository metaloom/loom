package io.metaloom.loom.db.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.asset.AssetDao;
import io.metaloom.loom.db.content.ContentDao;
import io.metaloom.loom.db.extension.ExtensionDao;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.group.GroupDao;
import io.metaloom.loom.db.model.ModelDao;
import io.metaloom.loom.db.namespace.NamespaceDao;
import io.metaloom.loom.db.role.RoleDao;
import io.metaloom.loom.db.user.UserDao;
import io.metaloom.loom.db.webhook.WebhookDao;

@Singleton
public class DaoCollectionImpl implements DaoCollection {

	@Inject
	public Lazy<ContentDao> contentDao;

	@Inject
	public Lazy<FieldDao> fieldDao;

	@Inject
	public Lazy<UserDao> userDao;

	@Inject
	public Lazy<RoleDao> roleDao;

	@Inject
	public Lazy<GroupDao> groupDao;

	@Inject
	public Lazy<AssetDao> assetDao;

	@Inject
	public Lazy<NamespaceDao> namespaceDao;

	@Inject
	public Lazy<ModelDao> modelDao;

	@Inject
	public Lazy<ExtensionDao> extensionDao;

	@Inject
	public Lazy<WebhookDao> webhookDao;

	@Inject
	public DaoCollectionImpl() {
	}

	@Override
	public ContentDao getContentDao() {
		return contentDao.get();
	}

	@Override
	public AssetDao getAssetDao() {
		return assetDao.get();
	}

	@Override
	public ExtensionDao getExtensionDao() {
		return extensionDao.get();
	}

	@Override
	public WebhookDao getWebhookDao() {
		return webhookDao.get();
	}

	@Override
	public FieldDao getFieldDao() {
		return fieldDao.get();
	}

	@Override
	public UserDao getUserDao() {
		return userDao.get();
	}

	@Override
	public GroupDao getGroupDao() {
		return groupDao.get();
	}

	@Override
	public RoleDao getRoleDao() {
		return roleDao.get();
	}

	@Override
	public ModelDao getModelDao() {
		return modelDao.get();
	}

	@Override
	public NamespaceDao getNamespaceDao() {
		return namespaceDao.get();
	}

}
