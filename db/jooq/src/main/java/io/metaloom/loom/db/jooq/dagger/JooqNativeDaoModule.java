package io.metaloom.loom.db.jooq.dagger;

import javax.inject.Singleton;

import org.jooq.Configuration;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.db.jooq.tables.daos.GroupDao;
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
}
