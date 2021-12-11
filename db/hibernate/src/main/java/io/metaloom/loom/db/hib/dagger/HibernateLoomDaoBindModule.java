package io.metaloom.loom.db.hib.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.field.FieldDao;
import io.metaloom.loom.db.hib.dao.asset.AssetDaoImpl;
import io.metaloom.loom.db.hib.dao.content.ContentDaoImpl;
import io.metaloom.loom.db.hib.dao.content.FieldDaoImpl;
import io.metaloom.loom.db.hib.dao.extension.ExtensionDaoImpl;
import io.metaloom.loom.db.hib.dao.group.GroupDaoImpl;
import io.metaloom.loom.db.hib.dao.model.ModelDaoImpl;
import io.metaloom.loom.db.hib.dao.namespace.NamespaceDaoImpl;
import io.metaloom.loom.db.hib.dao.role.RoleDaoImpl;
import io.metaloom.loom.db.hib.dao.tag.TagDaoImpl;
import io.metaloom.loom.db.hib.dao.user.HibLoomUserDaoImpl;
import io.metaloom.loom.db.hib.dao.user.UserTokenDaoImpl;
import io.metaloom.loom.db.hib.dao.webhook.WebhookDaoImpl;
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
public abstract class HibernateLoomDaoBindModule {

	@Binds
	abstract LoomUserDao userDao(HibLoomUserDaoImpl dao);

	@Binds
	abstract GroupDao groupDao(GroupDaoImpl dao);

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
