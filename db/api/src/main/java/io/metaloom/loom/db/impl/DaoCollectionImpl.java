package io.metaloom.loom.db.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.model.asset.AssetBinaryDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.content.ContentDao;
import io.metaloom.loom.db.model.extension.ExtensionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;

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
	public Lazy<AssetBinaryDao> assetBinaryDao;

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
	public ContentDao contentDao() {
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
	public ExtensionDao extensionDao() {
		return extensionDao.get();
	}

	@Override
	public WebhookDao webhookDao() {
		return webhookDao.get();
	}

	@Override
	public FieldDao fieldDao() {
		return fieldDao.get();
	}

	@Override
	public UserDao userDao() {
		return userDao.get();
	}

	@Override
	public GroupDao groupDao() {
		return groupDao.get();
	}

	@Override
	public RoleDao roleDao() {
		return roleDao.get();
	}

	@Override
	public ModelDao modelDao() {
		return modelDao.get();
	}

	@Override
	public NamespaceDao namespaceDao() {
		return namespaceDao.get();
	}

}
