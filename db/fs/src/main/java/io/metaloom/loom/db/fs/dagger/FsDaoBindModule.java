package io.metaloom.loom.db.fs.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.DaoCollectionImpl;
import io.metaloom.loom.db.asset.AssetsDao;
import io.metaloom.loom.db.asset.FsAssetsDaoImpl;
import io.metaloom.loom.db.content.ContentsDao;
import io.metaloom.loom.db.content.FsContentsDaoImpl;
import io.metaloom.loom.db.extension.ExtensionsDao;
import io.metaloom.loom.db.extension.FsExtensionsDaoImpl;
import io.metaloom.loom.db.field.FieldsDao;
import io.metaloom.loom.db.field.FsFieldsDaoImpl;
import io.metaloom.loom.db.group.FsGroupsDaoImpl;
import io.metaloom.loom.db.group.GroupsDao;
import io.metaloom.loom.db.model.FsModelsDaoImpl;
import io.metaloom.loom.db.model.ModelsDao;
import io.metaloom.loom.db.namespace.FsNamespacesDaoImpl;
import io.metaloom.loom.db.namespace.NamespacesDao;
import io.metaloom.loom.db.role.FsRolesDaoImpl;
import io.metaloom.loom.db.role.RolesDao;
import io.metaloom.loom.db.tag.FsTagsDaoImpl;
import io.metaloom.loom.db.tag.TagsDao;
import io.metaloom.loom.db.user.FsUsersDaoImpl;
import io.metaloom.loom.db.user.UsersDao;
import io.metaloom.loom.db.webhook.FsWebhooksDaoImpl;
import io.metaloom.loom.db.webhook.WebhooksDao;

@Module
public abstract class FsDaoBindModule {

	@Binds
	abstract ModelsDao modelsDao(FsModelsDaoImpl dao);

	@Binds
	abstract ContentsDao contentsDao(FsContentsDaoImpl dao);

	@Binds
	abstract FieldsDao fieldsDao(FsFieldsDaoImpl dao);

	@Binds
	abstract UsersDao usersDao(FsUsersDaoImpl dao);

	@Binds
	abstract GroupsDao groupsDao(FsGroupsDaoImpl dao);

	@Binds
	abstract RolesDao rolesDao(FsRolesDaoImpl dao);

	@Binds
	abstract TagsDao tagsDao(FsTagsDaoImpl dao);

	@Binds
	abstract NamespacesDao namespacesDao(FsNamespacesDaoImpl dao);

	@Binds
	abstract WebhooksDao webhookDao(FsWebhooksDaoImpl dao);

	@Binds
	abstract ExtensionsDao extensionsDao(FsExtensionsDaoImpl dao);

	@Binds
	abstract AssetsDao assetsDao(FsAssetsDaoImpl dao);

	@Binds
	abstract DaoCollection daoCollection(DaoCollectionImpl collection);
}
