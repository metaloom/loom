package io.metaloom.loom.db.fs.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.asset.LoomAssetDao;
import io.metaloom.loom.db.asset.FsAssetDaoImpl;
import io.metaloom.loom.db.content.LoomContentDao;
import io.metaloom.loom.db.content.FsContentsDaoImpl;
import io.metaloom.loom.db.extension.LoomExtensionDao;
import io.metaloom.loom.db.extension.FsExtensionDaoImpl;
import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.field.FsFieldDaoImpl;
import io.metaloom.loom.db.group.FsGroupDaoImpl;
import io.metaloom.loom.db.group.LoomGroupDao;
import io.metaloom.loom.db.model.FsModelDaoImpl;
import io.metaloom.loom.db.model.LoomModelDao;
import io.metaloom.loom.db.namespace.FsNamespaceDaoImpl;
import io.metaloom.loom.db.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.role.FsRoleDaoImpl;
import io.metaloom.loom.db.role.LoomRoleDao;
import io.metaloom.loom.db.tag.FsTagDaoImpl;
import io.metaloom.loom.db.tag.LoomTagDao;
import io.metaloom.loom.db.user.FsUserDaoImpl;
import io.metaloom.loom.db.user.LoomUserDao;
import io.metaloom.loom.db.webhook.FsWebhookDaoImpl;
import io.metaloom.loom.db.webhook.LoomWebhookDao;

@Module
public abstract class FsDaoBindModule {

	@Binds
	abstract LoomModelDao modelsDao(FsModelDaoImpl dao);

	@Binds
	abstract LoomContentDao contentsDao(FsContentsDaoImpl dao);

	@Binds
	abstract LoomFieldDao fieldsDao(FsFieldDaoImpl dao);

	@Binds
	abstract LoomUserDao usersDao(FsUserDaoImpl dao);

	@Binds
	abstract LoomGroupDao groupsDao(FsGroupDaoImpl dao);

	@Binds
	abstract LoomRoleDao rolesDao(FsRoleDaoImpl dao);

	@Binds
	abstract LoomTagDao tagsDao(FsTagDaoImpl dao);

	@Binds
	abstract LoomNamespaceDao namespacesDao(FsNamespaceDaoImpl dao);

	@Binds
	abstract LoomWebhookDao webhookDao(FsWebhookDaoImpl dao);

	@Binds
	abstract LoomExtensionDao extensionsDao(FsExtensionDaoImpl dao);

	@Binds
	abstract LoomAssetDao assetsDao(FsAssetDaoImpl dao);

}
