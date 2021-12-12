package io.metaloom.loom.db.fs.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.fs.dao.asset.FsAssetDaoImpl;
import io.metaloom.loom.db.fs.dao.content.FsContentsDaoImpl;
import io.metaloom.loom.db.fs.dao.extension.FsExtensionDaoImpl;
import io.metaloom.loom.db.fs.dao.field.FieldDaoImpl;
import io.metaloom.loom.db.fs.dao.group.GroupDaoImpl;
import io.metaloom.loom.db.fs.dao.model.FsModelDaoImpl;
import io.metaloom.loom.db.fs.dao.namespace.FsNamespaceDaoImpl;
import io.metaloom.loom.db.fs.dao.role.FsRoleDaoImpl;
import io.metaloom.loom.db.fs.dao.tag.FsTagDaoImpl;
import io.metaloom.loom.db.fs.dao.user.FsUserDaoImpl;
import io.metaloom.loom.db.fs.dao.webhook.FsWebhookDaoImpl;
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

@Module
public abstract class FsDaoBindModule {

	@Binds
	abstract ModelDao modelsDao(FsModelDaoImpl dao);

	@Binds
	abstract ContentDao contentsDao(FsContentsDaoImpl dao);

	@Binds
	abstract FieldDao fieldsDao(FieldDaoImpl dao);

	@Binds
	abstract LoomUserDao usersDao(FsUserDaoImpl dao);

	@Binds
	abstract GroupDao groupsDao(GroupDaoImpl dao);

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
