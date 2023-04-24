package io.metaloom.loom.db;

import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.model.asset.AssetBinaryDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.content.ContentDao;
import io.metaloom.loom.db.model.extension.ExtensionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;

/**
 * Aggregated list of all loom DAOs.
 */
public interface DaoCollection {

	ContentDao contentDao();

	FieldDao fieldDao();

	UserDao userDao();

	GroupDao groupDao();

	RoleDao roleDao();

	ExtensionDao extensionDao();

	WebhookDao webhookDao();

	NamespaceDao namespaceDao();

	ModelDao modelDao();

	AssetDao assetDao();

	AssetBinaryDao assetBinaryDao();

	PermissionDao permissionDao();

}
