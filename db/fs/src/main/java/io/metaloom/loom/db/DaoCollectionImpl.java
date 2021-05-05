package io.metaloom.loom.db;

import io.metaloom.loom.db.asset.AssetsDao;
import io.metaloom.loom.db.asset.FsAssetsDaoImpl;
import io.metaloom.loom.db.content.ContentsDao;
import io.metaloom.loom.db.content.FsContentsDaoImpl;
import io.metaloom.loom.db.extension.ExtensionsDao;
import io.metaloom.loom.db.extension.FsExtensionsDaoImpl;
import io.metaloom.loom.db.field.FieldsDao;
import io.metaloom.loom.db.field.FsFieldsDaoImpl;
import io.metaloom.loom.db.group.FsGroupsDaoImpl;
import io.metaloom.loom.db.group.GroupsDao;
import io.metaloom.loom.db.model.FsModelsDaoImpl;
import io.metaloom.loom.db.model.ModelsDao;
import io.metaloom.loom.db.namespace.FsNamespacesDaoImpl;
import io.metaloom.loom.db.namespace.NamespacesDao;
import io.metaloom.loom.db.role.FsRolesDaoImpl;
import io.metaloom.loom.db.role.RolesDao;
import io.metaloom.loom.db.user.FsUsersDaoImpl;
import io.metaloom.loom.db.user.UsersDao;
import io.metaloom.loom.db.webhook.FsWebhooksDaoImpl;
import io.metaloom.loom.db.webhook.WebhooksDao;

public class DaoCollectionImpl implements DaoCollection {

	private final ContentsDao contentsDao;
	private final FieldsDao fieldsDao;

	private final UsersDao usersDao;
	private final RolesDao rolesDao;
	private final GroupsDao groupsDao;

	private final AssetsDao assetsDao;
	private final NamespacesDao namespacesDao;
	private final ModelsDao modelsDao;

	private final ExtensionsDao extensionsDao;
	private final WebhooksDao webhooksDao;

	public DaoCollectionImpl() {
		this.contentsDao = new FsContentsDaoImpl();
		this.fieldsDao = new FsFieldsDaoImpl();

		this.usersDao = new FsUsersDaoImpl();
		this.groupsDao = new FsGroupsDaoImpl();
		this.rolesDao = new FsRolesDaoImpl();

		this.modelsDao = new FsModelsDaoImpl();
		this.assetsDao = new FsAssetsDaoImpl();
		this.namespacesDao = new FsNamespacesDaoImpl();

		this.extensionsDao = new FsExtensionsDaoImpl();
		this.webhooksDao = new FsWebhooksDaoImpl();
	}

	@Override
	public ContentsDao getContentsDao() {
		return contentsDao;
	}

	@Override
	public AssetsDao getAssetsDao() {
		return assetsDao;
	}

	@Override
	public ExtensionsDao getExtensionsDao() {
		return extensionsDao;
	}

	@Override
	public WebhooksDao getWebhooksDao() {
		return webhooksDao;
	}

	@Override
	public FieldsDao getFieldsDao() {
		return fieldsDao;
	}

	@Override
	public UsersDao getUsersDao() {
		return usersDao;
	}

	@Override
	public GroupsDao getGroupsDao() {
		return groupsDao;
	}

	@Override
	public RolesDao getRolesDao() {
		return rolesDao;
	}

	@Override
	public ModelsDao getModelsDao() {
		return modelsDao;
	}

	@Override
	public NamespacesDao getNamespacesDao() {
		return namespacesDao;
	}

}
