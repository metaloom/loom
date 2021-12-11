package io.metaloom.loom.db.jooq.dagger;

import javax.inject.Singleton;

import org.jooq.Configuration;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;

@Module
public class JooqNativeDaoModule {

	@Provides
	@Singleton
	public UserDao userDao(Configuration configuration) {
		return new UserDao(configuration);
	}
}
