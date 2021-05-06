package io.metaloom.loom.db.jooq.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.asset.AssetDao;
import io.metaloom.loom.db.asset.JooqAssetDaoImpl;
import io.metaloom.loom.db.content.ContentDao;
import io.metaloom.loom.db.content.JooqContentDaoImpl;
import io.metaloom.loom.db.extension.ExtensionDao;
import io.metaloom.loom.db.extension.JooqExtensionDaoImpl;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.field.JooqFieldDaoImpl;
import io.metaloom.loom.db.group.GroupDao;
import io.metaloom.loom.db.group.JooqGroupDaoImpl;
import io.metaloom.loom.db.model.JooqModelDaoImpl;
import io.metaloom.loom.db.model.ModelDao;
import io.metaloom.loom.db.namespace.JooqNamespaceDaoImpl;
import io.metaloom.loom.db.namespace.NamespaceDao;
import io.metaloom.loom.db.role.JooqRoleDaoImpl;
import io.metaloom.loom.db.role.RoleDao;
import io.metaloom.loom.db.tag.JooqTagDaoImpl;
import io.metaloom.loom.db.tag.TagDao;
import io.metaloom.loom.db.user.JooqUserDaoImpl;
import io.metaloom.loom.db.user.UserDao;
import io.metaloom.loom.db.webhook.JooqWebhookDaoImpl;
import io.metaloom.loom.db.webhook.WebhookDao;

@Module
public abstract class JooqDaoBindModule {

	@Binds
	abstract ModelDao modelsDao(JooqModelDaoImpl dao);

	@Binds
	abstract ContentDao contentsDao(JooqContentDaoImpl dao);

	@Binds
	abstract FieldDao fieldsDao(JooqFieldDaoImpl dao);

	@Binds
	abstract UserDao usersDao(JooqUserDaoImpl dao);

	@Binds
	abstract GroupDao groupsDao(JooqGroupDaoImpl dao);

	@Binds
	abstract RoleDao rolesDao(JooqRoleDaoImpl dao);

	@Binds
	abstract TagDao tagsDao(JooqTagDaoImpl dao);

	@Binds
	abstract NamespaceDao namespacesDao(JooqNamespaceDaoImpl dao);

	@Binds
	abstract WebhookDao webhookDao(JooqWebhookDaoImpl dao);

	@Binds
	abstract ExtensionDao extensionsDao(JooqExtensionDaoImpl dao);

	@Binds
	abstract AssetDao assetsDao(JooqAssetDaoImpl dao);

}
