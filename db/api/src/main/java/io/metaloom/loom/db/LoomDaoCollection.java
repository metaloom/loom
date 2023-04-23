package io.metaloom.loom.db;

import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.model.asset.AssetBinaryDao;
import io.metaloom.loom.db.model.asset.AssetDao;
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

	LoomContentDao contentDao();

	LoomFieldDao fieldDao();

	LoomUserDao userDao();

	LoomGroupDao groupDao();

	LoomRoleDao roleDao();

	LoomExtensionDao extensionDao();

	LoomWebhookDao webhookDao();

	LoomNamespaceDao namespaceDao();

	LoomModelDao modelDao();

	AssetDao assetDao();

	AssetBinaryDao assetBinaryDao();

}
