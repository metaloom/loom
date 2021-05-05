package io.metaloom.loom.db;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;
import io.metaloom.loom.db.asset.AssetsDao;
import io.metaloom.loom.db.content.ContentsDao;
import io.metaloom.loom.db.extension.ExtensionsDao;
import io.metaloom.loom.db.field.FieldsDao;
import io.metaloom.loom.db.group.GroupsDao;
import io.metaloom.loom.db.model.ModelsDao;
import io.metaloom.loom.db.namespace.NamespacesDao;
import io.metaloom.loom.db.role.RolesDao;
import io.metaloom.loom.db.user.UsersDao;
import io.metaloom.loom.db.webhook.WebhooksDao;

@Singleton
public class DaoCollectionImpl implements DaoCollection {

	@Inject
	public Lazy<ContentsDao> contentsDao;

	@Inject
	public Lazy<FieldsDao> fieldsDao;

	@Inject
	public Lazy<UsersDao> usersDao;

	@Inject
	public Lazy<RolesDao> rolesDao;

	@Inject
	public Lazy<GroupsDao> groupsDao;

	@Inject
	public Lazy<AssetsDao> assetsDao;

	@Inject
	public Lazy<NamespacesDao> namespacesDao;

	@Inject
	public Lazy<ModelsDao> modelsDao;

	@Inject
	public Lazy<ExtensionsDao> extensionsDao;

	@Inject
	public Lazy<WebhooksDao> webhooksDao;

	@Inject
	public DaoCollectionImpl() {
	}

	@Override
	public ContentsDao getContentsDao() {
		return contentsDao.get();
	}

	@Override
	public AssetsDao getAssetsDao() {
		return assetsDao.get();
	}

	@Override
	public ExtensionsDao getExtensionsDao() {
		return extensionsDao.get();
	}

	@Override
	public WebhooksDao getWebhooksDao() {
		return webhooksDao.get();
	}

	@Override
	public FieldsDao getFieldsDao() {
		return fieldsDao.get();
	}

	@Override
	public UsersDao getUsersDao() {
		return usersDao.get();
	}

	@Override
	public GroupsDao getGroupsDao() {
		return groupsDao.get();
	}

	@Override
	public RolesDao getRolesDao() {
		return rolesDao.get();
	}

	@Override
	public ModelsDao getModelsDao() {
		return modelsDao.get();
	}

	@Override
	public NamespacesDao getNamespacesDao() {
		return namespacesDao.get();
	}

}
