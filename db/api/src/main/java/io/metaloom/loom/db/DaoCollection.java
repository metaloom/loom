package io.metaloom.loom.db;

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

public interface DaoCollection {

	ContentsDao getContentsDao();

	FieldsDao getFieldsDao();

	UsersDao getUsersDao();

	GroupsDao getGroupsDao();

	RolesDao getRolesDao();

	ExtensionsDao getExtensionsDao();

	WebhooksDao getWebhooksDao();

	NamespacesDao getNamespacesDao();

	ModelsDao getModelsDao();

	AssetsDao getAssetsDao();

}
