package io.metaloom.loom.db;

import io.metaloom.loom.db.asset.LoomAssetDao;
import io.metaloom.loom.db.content.LoomContentDao;
import io.metaloom.loom.db.extension.LoomExtensionDao;
import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.group.LoomGroupDao;
import io.metaloom.loom.db.model.LoomModelDao;
import io.metaloom.loom.db.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.role.LoomRoleDao;
import io.metaloom.loom.db.user.LoomUserDao;
import io.metaloom.loom.db.webhook.LoomWebhookDao;

public interface DaoCollection {

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
