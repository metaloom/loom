package io.metaloom.loom.db.jooq.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.jooq.dao.asset.AssetDaoImpl;
import io.metaloom.loom.db.jooq.dao.asset.bin.BinaryDaoImpl;
import io.metaloom.loom.db.jooq.dao.collection.CollectionDaoImpl;
import io.metaloom.loom.db.jooq.dao.group.GroupDaoImpl;
import io.metaloom.loom.db.jooq.dao.library.LibraryDaoImpl;
import io.metaloom.loom.db.jooq.dao.perm.PermissionDaoImpl;
import io.metaloom.loom.db.jooq.dao.role.RoleDaoImpl;
import io.metaloom.loom.db.jooq.dao.tag.TagDaoImpl;
import io.metaloom.loom.db.jooq.dao.token.TokenDaoImpl;
import io.metaloom.loom.db.jooq.dao.user.UserDaoImpl;
import io.metaloom.loom.db.jooq.dao.webhook.WebhookDaoImpl;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.model.collection.CollectionDao;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.tag.TagDao;
import io.metaloom.loom.db.model.token.TokenDao;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.model.webhook.WebhookDao;

@Module
public abstract class JooqLoomDaoBindModule {

	@Binds
	abstract UserDao bindLoomUserDao(UserDaoImpl e);

	@Binds
	abstract GroupDao bindGroupDao(GroupDaoImpl e);

	@Binds
	abstract RoleDao roleDao(RoleDaoImpl dao);

	@Binds
	abstract TokenDao tokenDao(TokenDaoImpl dao);

	@Binds
	abstract TagDao tagDao(TagDaoImpl dao);

	@Binds
	abstract WebhookDao webhookDao(WebhookDaoImpl dao);

	@Binds
	abstract BinaryDao assetBinaryDao(BinaryDaoImpl dao);

	@Binds
	abstract AssetDao assetDao(AssetDaoImpl dao);

	@Binds
	abstract CollectionDao collectionDao(CollectionDaoImpl dao);

	@Binds
	abstract PermissionDao permissionDao(PermissionDaoImpl dao);

	@Binds
	abstract LibraryDao libraryDao(LibraryDaoImpl dao);

}
