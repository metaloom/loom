package io.metaloom.loom.db.jooq.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.jooq.dao.asset.AssetDaoImpl;
import io.metaloom.loom.db.jooq.dao.content.ContentDaoImpl;
import io.metaloom.loom.db.jooq.dao.field.FieldDaoImpl;
import io.metaloom.loom.db.jooq.dao.group.GroupDaoImpl;
import io.metaloom.loom.db.jooq.dao.model.ModelDaoImpl;
import io.metaloom.loom.db.jooq.dao.namespace.NamespaceDaoImpl;
import io.metaloom.loom.db.jooq.dao.role.ExtensionDaoImpl;
import io.metaloom.loom.db.jooq.dao.role.RoleDaoImpl;
import io.metaloom.loom.db.jooq.dao.role.WebhookDaoImpl;
import io.metaloom.loom.db.jooq.dao.tag.TagDaoImpl;
import io.metaloom.loom.db.jooq.dao.token.UserTokenDaoImpl;
import io.metaloom.loom.db.jooq.dao.user.LoomUserDaoImpl;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.content.ContentDao;
import io.metaloom.loom.db.model.extension.ExtensionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.model.ModelDao;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.tag.TagDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.db.model.user.UserTokenDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;

@Module
public abstract class JooqLoomDaoBindModule {

	@Binds
	abstract LoomUserDao bindLoomUserDao(LoomUserDaoImpl e);

	@Binds
	abstract GroupDao bindGroupDao(GroupDaoImpl e);
	
	@Binds
	abstract RoleDao roleDao(RoleDaoImpl dao);

	@Binds
	abstract ModelDao modelDao(ModelDaoImpl dao);

	@Binds
	abstract ContentDao contentDao(ContentDaoImpl dao);

	@Binds
	abstract FieldDao fieldDao(FieldDaoImpl dao);

	@Binds
	abstract UserTokenDao userTokenDao(UserTokenDaoImpl dao);

	@Binds
	abstract TagDao tagDao(TagDaoImpl dao);

	@Binds
	abstract NamespaceDao namespaceDao(NamespaceDaoImpl dao);

	@Binds
	abstract WebhookDao webhookDao(WebhookDaoImpl dao);

	@Binds
	abstract ExtensionDao extensionDao(ExtensionDaoImpl dao);

	@Binds
	abstract AssetDao assetDao(AssetDaoImpl dao);
}
	