package io.metaloom.loom.db.fs.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.asset.FsAssetDaoImpl;
import io.metaloom.loom.db.content.FsContentsDaoImpl;
import io.metaloom.loom.db.extension.FsExtensionDaoImpl;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.field.FsFieldDaoImpl;
import io.metaloom.loom.db.group.FsGroupDaoImpl;
import io.metaloom.loom.db.model.FsModelDaoImpl;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.content.ContentDao;
import io.metaloom.loom.db.model.extension.ExtensionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.tag.TagDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;
import io.metaloom.loom.db.namespace.FsNamespaceDaoImpl;
import io.metaloom.loom.db.role.FsRoleDaoImpl;
import io.metaloom.loom.db.tag.FsTagDaoImpl;
import io.metaloom.loom.db.user.FsUserDaoImpl;
import io.metaloom.loom.db.webhook.FsWebhookDaoImpl;

@Module
public abstract class FsDaoBindModule {

	@Binds
	abstract ModelDao modelsDao(FsModelDaoImpl dao);

	@Binds
	abstract ContentDao contentsDao(FsContentsDaoImpl dao);

	@Binds
	abstract FieldDao fieldsDao(FsFieldDaoImpl dao);

	@Binds
	abstract LoomUserDao usersDao(FsUserDaoImpl dao);

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
