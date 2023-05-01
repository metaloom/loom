package io.metaloom.loom.db.jooq.dagger;

import javax.inject.Singleton;

import org.jooq.Configuration;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.db.jooq.tables.daos.JooqAssetDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqBinaryDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqCollectionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqLibraryDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqRoleDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqRoleGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqRolePermissionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTokenDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTokenPermissionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserPermissionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqWebhookDao;

@Module
public class JooqNativeDaoModule {

	@Provides
	@Singleton
	public JooqUserDao userDao(Configuration configuration) {
		return new JooqUserDao(configuration);
	}

	@Provides
	@Singleton
	public JooqTokenDao userTokenDao(Configuration configuration) {
		return new JooqTokenDao(configuration);
	}

	@Provides
	@Singleton
	public JooqGroupDao groupDao(Configuration configuration) {
		return new JooqGroupDao(configuration);
	}

	@Provides
	@Singleton
	public JooqUserGroupDao userGroupDao(Configuration configuration) {
		return new JooqUserGroupDao(configuration);
	}

	@Provides
	@Singleton
	public JooqWebhookDao webhookDao(Configuration configuration) {
		return new JooqWebhookDao(configuration);
	}

	@Provides
	@Singleton
	public JooqRoleDao roleDao(Configuration configuration) {
		return new JooqRoleDao(configuration);
	}

	@Provides
	@Singleton
	public JooqAssetDao assetDao(Configuration configuration) {
		return new JooqAssetDao(configuration);
	}

	@Provides
	@Singleton
	public JooqBinaryDao assetBinaryDao(Configuration configuration) {
		return new JooqBinaryDao(configuration);
	}

	@Provides
	@Singleton
	public JooqRolePermissionDao rolePermissionDao(Configuration configuration) {
		return new JooqRolePermissionDao(configuration);
	}

	@Provides
	@Singleton
	public JooqUserPermissionDao userPermissionDao(Configuration configuration) {
		return new JooqUserPermissionDao(configuration);
	}

	@Provides
	@Singleton
	public JooqTokenPermissionDao tokenPermissionDao(Configuration configuration) {
		return new JooqTokenPermissionDao(configuration);
	}

	@Provides
	@Singleton
	public JooqRoleGroupDao roleGroupDao(Configuration configuration) {
		return new JooqRoleGroupDao(configuration);
	}

	@Provides
	@Singleton
	public JooqCollectionDao collectionDao(Configuration configuration) {
		return new JooqCollectionDao(configuration);
	}

	@Provides
	@Singleton
	public JooqLibraryDao libraryDao(Configuration configuration) {
		return new JooqLibraryDao(configuration);
	}

}
