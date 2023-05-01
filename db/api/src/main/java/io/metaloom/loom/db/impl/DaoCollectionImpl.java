package io.metaloom.loom.db.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.model.collection.CollectionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;

@Singleton
public class DaoCollectionImpl implements DaoCollection {

	private Lazy<UserDao> userDao;
	private Lazy<GroupDao> groupDao;
	private Lazy<RoleDao> roleDao;
	private Lazy<AssetDao> assetDao;
	private Lazy<PermissionDao> permissionDao;
	private Lazy<BinaryDao> assetBinaryDao;
	private Lazy<WebhookDao> webhookDao;
	private Lazy<CollectionDao> collectionDao;
	private Lazy<LibraryDao> libraryDao;

	@Inject
	public DaoCollectionImpl(Lazy<UserDao> userDao, Lazy<PermissionDao> permissionDao,
		Lazy<RoleDao> roleDao, Lazy<GroupDao> groupDao, Lazy<AssetDao> assetDao, Lazy<BinaryDao> assetBinaryDao,
		Lazy<WebhookDao> webhookDao, Lazy<CollectionDao> collectionDao, Lazy<LibraryDao> libraryDao) {
		this.userDao = userDao;
		this.groupDao = groupDao;
		this.roleDao = roleDao;
		this.assetDao = assetDao;
		this.permissionDao = permissionDao;
		this.assetBinaryDao = assetBinaryDao;
		this.webhookDao = webhookDao;
		this.libraryDao = libraryDao;
		this.collectionDao = collectionDao;
	}

	@Override
	public AssetDao assetDao() {
		return assetDao.get();
	}

	@Override
	public BinaryDao assetBinaryDao() {
		return assetBinaryDao.get();
	}

	@Override
	public WebhookDao webhookDao() {
		return webhookDao.get();
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
	public PermissionDao permissionDao() {
		return permissionDao.get();
	}

	@Override
	public LibraryDao libraryDao() {
		return libraryDao.get();
	}

	@Override
	public CollectionDao collectionDao() {
		return collectionDao.get();
	}

}
