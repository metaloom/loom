package io.metaloom.loom.db;

import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.content.ContentDao;
import io.metaloom.loom.db.model.extension.ExtensionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;

/**
 * Aggregated list of all loom DAOs.
 */
public interface LoomDaoCollection {

	ContentDao getContentDao();

	FieldDao getFieldDao();

	LoomUserDao getUserDao();

	GroupDao getGroupDao();

	RoleDao getRoleDao();

	ExtensionDao getExtensionDao();

	WebhookDao getWebhookDao();

	NamespaceDao getNamespaceDao();

	ModelDao getModelDao();

	AssetDao getAssetDao();

}
