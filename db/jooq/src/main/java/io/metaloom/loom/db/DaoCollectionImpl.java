package io.metaloom.loom.db;

import io.metaloom.loom.db.asset.AssetsDao;
import io.metaloom.loom.db.asset.JooqAssetsDaoImpl;
import io.metaloom.loom.db.content.ContentsDao;
import io.metaloom.loom.db.content.JooqContentsDaoImpl;
import io.metaloom.loom.db.extension.ExtensionsDao;
import io.metaloom.loom.db.extension.JooqExtensionsDaoImpl;
import io.metaloom.loom.db.field.FieldsDao;
import io.metaloom.loom.db.field.JooqFieldsDaoImpl;
import io.metaloom.loom.db.group.GroupsDao;
import io.metaloom.loom.db.group.JooqGroupsDaoImpl;
import io.metaloom.loom.db.model.JooqModelsDaoImpl;
import io.metaloom.loom.db.model.ModelsDao;
import io.metaloom.loom.db.namespace.JooqNamespacesDaoImpl;
import io.metaloom.loom.db.namespace.NamespacesDao;
import io.metaloom.loom.db.role.JooqRolesDaoImpl;
import io.metaloom.loom.db.role.RolesDao;
import io.metaloom.loom.db.user.JooqUsersDaoImpl;
import io.metaloom.loom.db.user.UsersDao;
import io.metaloom.loom.db.webhook.JooqWebhooksDaoImpl;
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
		this.contentsDao = new JooqContentsDaoImpl(null);
		this.fieldsDao = new JooqFieldsDaoImpl(null);

		this.usersDao = new JooqUsersDaoImpl(null);
		this.groupsDao = new JooqGroupsDaoImpl(null);
		this.rolesDao = new JooqRolesDaoImpl(null);

		this.modelsDao = new JooqModelsDaoImpl(null);
		this.assetsDao = new JooqAssetsDaoImpl(null);
		this.namespacesDao = new JooqNamespacesDaoImpl(null);

		this.extensionsDao = new JooqExtensionsDaoImpl(null);
		this.webhooksDao = new JooqWebhooksDaoImpl(null);
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
