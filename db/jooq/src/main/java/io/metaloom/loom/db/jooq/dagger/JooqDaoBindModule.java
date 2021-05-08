package io.metaloom.loom.db.jooq.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.asset.LoomAssetDao;
import io.metaloom.loom.db.asset.JooqAssetDaoImpl;
import io.metaloom.loom.db.content.LoomContentDao;
import io.metaloom.loom.db.content.JooqContentDaoImpl;
import io.metaloom.loom.db.extension.LoomExtensionDao;
import io.metaloom.loom.db.extension.JooqExtensionDaoImpl;
import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.field.JooqFieldDaoImpl;
import io.metaloom.loom.db.group.LoomGroupDao;
import io.metaloom.loom.db.group.JooqGroupDaoImpl;
import io.metaloom.loom.db.model.JooqModelDaoImpl;
import io.metaloom.loom.db.model.LoomModelDao;
import io.metaloom.loom.db.namespace.JooqNamespaceDaoImpl;
import io.metaloom.loom.db.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.role.JooqRoleDaoImpl;
import io.metaloom.loom.db.role.LoomRoleDao;
import io.metaloom.loom.db.tag.JooqTagDaoImpl;
import io.metaloom.loom.db.tag.LoomTagDao;
import io.metaloom.loom.db.user.JooqUserDaoImpl;
import io.metaloom.loom.db.user.LoomUserDao;
import io.metaloom.loom.db.webhook.JooqWebhookDaoImpl;
import io.metaloom.loom.db.webhook.LoomWebhookDao;

@Module
public abstract class JooqDaoBindModule {

	@Binds
	abstract LoomModelDao modelsDao(JooqModelDaoImpl dao);

	@Binds
	abstract LoomContentDao contentsDao(JooqContentDaoImpl dao);

	@Binds
	abstract LoomFieldDao fieldsDao(JooqFieldDaoImpl dao);

	@Binds
	abstract LoomUserDao usersDao(JooqUserDaoImpl dao);

	@Binds
	abstract LoomGroupDao groupsDao(JooqGroupDaoImpl dao);

	@Binds
	abstract LoomRoleDao rolesDao(JooqRoleDaoImpl dao);

	@Binds
	abstract LoomTagDao tagsDao(JooqTagDaoImpl dao);

	@Binds
	abstract LoomNamespaceDao namespacesDao(JooqNamespaceDaoImpl dao);

	@Binds
	abstract LoomWebhookDao webhookDao(JooqWebhookDaoImpl dao);

	@Binds
	abstract LoomExtensionDao extensionsDao(JooqExtensionDaoImpl dao);

	@Binds
	abstract LoomAssetDao assetsDao(JooqAssetDaoImpl dao);

}
