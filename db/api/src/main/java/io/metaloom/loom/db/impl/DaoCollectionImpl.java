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
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;

@Singleton
public class DaoCollectionImpl implements DaoCollection {

	private Lazy<ContentDao> contentDao;
	private Lazy<FieldDao> fieldDao;
	private Lazy<UserDao> userDao;
	private Lazy<GroupDao> groupDao;
	private Lazy<RoleDao> roleDao;
	private Lazy<AssetDao> assetDao;
	private Lazy<PermissionDao> permissionDao;
	private Lazy<AssetBinaryDao> assetBinaryDao;
	private Lazy<WebhookDao> webhookDao;
	private Lazy<ExtensionDao> extensionDao;
	private Lazy<ModelDao> modelDao;
	private Lazy<NamespaceDao> namespaceDao;

	@Inject
	public DaoCollectionImpl(Lazy<ContentDao> contentDao, Lazy<FieldDao> fieldDao, Lazy<UserDao> userDao, Lazy<PermissionDao> permissionDao,
		Lazy<RoleDao> roleDao, Lazy<GroupDao> groupDao, Lazy<AssetDao> assetDao, Lazy<AssetBinaryDao> assetBinaryDao, Lazy<NamespaceDao> namespaceDao,
		Lazy<ModelDao> modelDao, Lazy<ExtensionDao> extensionDao, Lazy<WebhookDao> webhookDao) {
		this.contentDao = contentDao;
		this.fieldDao = fieldDao;
		this.userDao = userDao;
		this.groupDao = groupDao;
		this.roleDao = roleDao;
		this.assetDao = assetDao;
		this.permissionDao = permissionDao;
		this.assetBinaryDao = assetBinaryDao;
		this.webhookDao = webhookDao;
		this.extensionDao = extensionDao;
		this.modelDao = modelDao;
		this.namespaceDao = namespaceDao;
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

	@Override
	public PermissionDao permissionDao() {
		return permissionDao.get();
	}

}
