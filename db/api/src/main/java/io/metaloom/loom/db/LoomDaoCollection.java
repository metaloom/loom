package io.metaloom.loom.db;

import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.model.asset.LoomAssetDao;
import io.metaloom.loom.db.model.content.LoomContentDao;
import io.metaloom.loom.db.model.extension.LoomExtensionDao;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.model.LoomModelDao;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.model.role.LoomRoleDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.db.model.webhook.LoomWebhookDao;

/**
 * Aggregated list of all loom DAOs.
 */
public interface LoomDaoCollection {

	LoomContentDao getContentDao();

	LoomFieldDao getFieldDao();

	LoomUserDao getUserDao();

	LoomGroupDao getGroupDao();

	LoomRoleDao getRoleDao();

	LoomExtensionDao getExtensionDao();

	LoomWebhookDao getWebhookDao();

	LoomNamespaceDao getNamespaceDao();

	LoomModelDao getModelDao();

	LoomAssetDao getAssetDao();

}
