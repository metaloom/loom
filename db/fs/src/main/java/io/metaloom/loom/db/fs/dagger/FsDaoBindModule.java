package io.metaloom.loom.db.fs.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.asset.AssetDao;
import io.metaloom.loom.db.asset.FsAssetDaoImpl;
import io.metaloom.loom.db.content.ContentDao;
import io.metaloom.loom.db.content.FsContentsDaoImpl;
import io.metaloom.loom.db.extension.ExtensionDao;
import io.metaloom.loom.db.extension.FsExtensionDaoImpl;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.field.FsFieldDaoImpl;
import io.metaloom.loom.db.group.FsGroupDaoImpl;
import io.metaloom.loom.db.group.GroupDao;
import io.metaloom.loom.db.impl.DaoCollectionImpl;
import io.metaloom.loom.db.model.FsModelDaoImpl;
import io.metaloom.loom.db.model.ModelDao;
import io.metaloom.loom.db.namespace.FsNamespaceDaoImpl;
import io.metaloom.loom.db.namespace.NamespaceDao;
import io.metaloom.loom.db.role.FsRoleDaoImpl;
import io.metaloom.loom.db.role.RoleDao;
import io.metaloom.loom.db.tag.FsTagDaoImpl;
import io.metaloom.loom.db.tag.TagDao;
import io.metaloom.loom.db.user.FsUserDaoImpl;
import io.metaloom.loom.db.user.UserDao;
import io.metaloom.loom.db.webhook.FsWebhookDaoImpl;
import io.metaloom.loom.db.webhook.WebhookDao;

@Module
public abstract class FsDaoBindModule {

	@Binds
	abstract ModelDao modelsDao(FsModelDaoImpl dao);

	@Binds
	abstract ContentDao contentsDao(FsContentsDaoImpl dao);

	@Binds
	abstract FieldDao fieldsDao(FsFieldDaoImpl dao);

	@Binds
	abstract UserDao usersDao(FsUserDaoImpl dao);

	@Binds
	abstract GroupDao groupsDao(FsGroupDaoImpl dao);

	@Binds
	abstract RoleDao rolesDao(FsRoleDaoImpl dao);

	@Binds
	abstract TagDao tagsDao(FsTagDaoImpl dao);

	@Binds
	abstract NamespaceDao namespacesDao(FsNamespaceDaoImpl dao);

	@Binds
	abstract WebhookDao webhookDao(FsWebhookDaoImpl dao);

	@Binds
	abstract ExtensionDao extensionsDao(FsExtensionDaoImpl dao);

	@Binds
	abstract AssetDao assetsDao(FsAssetDaoImpl dao);

}
