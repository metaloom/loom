package io.metaloom.loom.db.jooq.dagger;

import javax.inject.Singleton;

import org.jooq.Configuration;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.db.jooq.tables.daos.AssetDao;
import io.metaloom.loom.db.jooq.tables.daos.FieldDao;
import io.metaloom.loom.db.jooq.tables.daos.GroupDao;
import io.metaloom.loom.db.jooq.tables.daos.ModelDao;
import io.metaloom.loom.db.jooq.tables.daos.NamespaceDao;
import io.metaloom.loom.db.jooq.tables.daos.RoleDao;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.daos.UserGroupDao;

@Module
public class JooqNativeDaoModule {

	@Provides
	@Singleton
	public UserDao userDao(Configuration configuration) {
		return new UserDao(configuration);
	}

	@Provides
	@Singleton
	public GroupDao groupDao(Configuration configuration) {
		return new GroupDao(configuration);
	}

	@Provides
	@Singleton
	public UserGroupDao userGroupDao(Configuration configuration) {
		return new UserGroupDao(configuration);
	}

	@Provides
	@Singleton
	public ModelDao modelDao(Configuration configuration) {
		return new ModelDao(configuration);
	}

	@Provides
	@Singleton
	public FieldDao fieldDao(Configuration configuration) {
		return new FieldDao(configuration);
	}

	@Provides
	@Singleton
	public NamespaceDao namespaceDao(Configuration configuration) {
		return new NamespaceDao(configuration);
	}

	@Provides
	@Singleton
	public RoleDao roleDao(Configuration configuration) {
		return new RoleDao(configuration);
	}

	@Provides
	@Singleton
	public AssetDao assetDao(Configuration configuration) {
		return new AssetDao(configuration);
	}
}
