package io.metaloom.loom.db;

import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.model.collection.CollectionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;

/**
 * Aggregated list of all loom DAOs.
 */
public interface DaoCollection {

	UserDao userDao();

	GroupDao groupDao();

	RoleDao roleDao();

	WebhookDao webhookDao();

	AssetDao assetDao();

	BinaryDao assetBinaryDao();

	PermissionDao permissionDao();

	LibraryDao libraryDao();

	CollectionDao collectionDao();

}
