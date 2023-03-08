package io.metaloom.loom.db.jooq.dagger;

import javax.inject.Singleton;

import org.jooq.Configuration;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.db.jooq.tables.daos.JooqAssetBinarieDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqAssetDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqContentDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqExtensionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqFieldDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqModelDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqNamespaceDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqRoleDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserTokenDao;
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
	public JooqUserTokenDao userTokenDao(Configuration configuration) {
		return new JooqUserTokenDao(configuration);
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
	public JooqModelDao modelDao(Configuration configuration) {
		return new JooqModelDao(configuration);
	}

	@Provides
	@Singleton
	public JooqContentDao contentDao(Configuration configuration) {
		return new JooqContentDao(configuration);
	}

	@Provides
	@Singleton
	public JooqExtensionDao extensionDao(Configuration configuration) {
		return new JooqExtensionDao(configuration);
	}

	@Provides
	@Singleton
	public JooqWebhookDao webhookDao(Configuration configuration) {
		return new JooqWebhookDao(configuration);
	}

	@Provides
	@Singleton
	public JooqFieldDao fieldDao(Configuration configuration) {
		return new JooqFieldDao(configuration);
	}

	@Provides
	@Singleton
	public JooqNamespaceDao namespaceDao(Configuration configuration) {
		return new JooqNamespaceDao(configuration);
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
	public JooqAssetBinarieDao assetBinaryDao(Configuration configuration) {
		return new JooqAssetBinarieDao(configuration);
	}
}
