package io.metaloom.loom.db.jooq.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.field.LoomFieldDao;
import io.metaloom.loom.db.jooq.dao.asset.AssetBinaryDaoImpl;
import io.metaloom.loom.db.jooq.dao.asset.AssetDaoImpl;
import io.metaloom.loom.db.jooq.dao.content.ContentDaoImpl;
import io.metaloom.loom.db.jooq.dao.field.LoomFieldDaoImpl;
import io.metaloom.loom.db.jooq.dao.group.LoomGroupDaoImpl;
import io.metaloom.loom.db.jooq.dao.model.LoomModelDaoImpl;
import io.metaloom.loom.db.jooq.dao.namespace.LoomNamespaceDaoImpl;
import io.metaloom.loom.db.jooq.dao.perm.PermissionDaoImpl;
import io.metaloom.loom.db.jooq.dao.role.LoomRoleDaoImpl;
import io.metaloom.loom.db.jooq.dao.tag.LoomTagDaoImpl;
import io.metaloom.loom.db.jooq.dao.token.UserTokenDaoImpl;
import io.metaloom.loom.db.jooq.dao.user.LoomUserDaoImpl;
import io.metaloom.loom.db.jooq.dao.webhook.LoomWebhookDaoImpl;
import io.metaloom.loom.db.jooq.extension.ExtensionDaoImpl;
import io.metaloom.loom.db.model.asset.AssetBinaryDao;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.content.LoomContentDao;
import io.metaloom.loom.db.model.extension.LoomExtensionDao;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.model.LoomModelDao;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.LoomRoleDao;
import io.metaloom.loom.db.model.tag.LoomTagDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.db.model.user.LoomUserTokenDao;
import io.metaloom.loom.db.model.webhook.LoomWebhookDao;

@Module
public abstract class JooqLoomDaoBindModule {

	@Binds
	abstract LoomUserDao bindLoomUserDao(LoomUserDaoImpl e);

	@Binds
	abstract LoomGroupDao bindGroupDao(LoomGroupDaoImpl e);

	@Binds
	abstract LoomRoleDao roleDao(LoomRoleDaoImpl dao);

	@Binds
	abstract LoomModelDao modelDao(LoomModelDaoImpl dao);

	@Binds
	abstract LoomContentDao contentDao(ContentDaoImpl dao);

	@Binds
	abstract LoomFieldDao fieldDao(LoomFieldDaoImpl dao);

	@Binds
	abstract LoomUserTokenDao userTokenDao(UserTokenDaoImpl dao);

	@Binds
	abstract LoomTagDao tagDao(LoomTagDaoImpl dao);

	@Binds
	abstract LoomNamespaceDao namespaceDao(LoomNamespaceDaoImpl dao);

	@Binds
	abstract LoomWebhookDao webhookDao(LoomWebhookDaoImpl dao);

	@Binds
	abstract LoomExtensionDao extensionDao(ExtensionDaoImpl dao);

	@Binds
	abstract AssetDao assetDao(AssetDaoImpl dao);

	@Binds
	abstract AssetBinaryDao assetBinaryDao(AssetBinaryDaoImpl dao);
	
	@Binds
	abstract PermissionDao permissionDao(PermissionDaoImpl dao);
}
