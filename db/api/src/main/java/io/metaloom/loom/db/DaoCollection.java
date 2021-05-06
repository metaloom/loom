package io.metaloom.loom.db;

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

public interface DaoCollection {

	ContentDao getContentDao();

	FieldDao getFieldDao();

	UserDao getUserDao();

	GroupDao getGroupDao();

	RoleDao getRoleDao();

	ExtensionDao getExtensionDao();

	WebhookDao getWebhookDao();

	NamespaceDao getNamespaceDao();

	ModelDao getModelDao();

	AssetDao getAssetDao();

}
