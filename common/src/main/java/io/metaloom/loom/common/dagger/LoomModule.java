package io.metaloom.loom.common.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.metaloom.loom.api.options.DatabaseOptions;
import io.metaloom.loom.api.options.LoomOptions;

@Module
public class LoomModule {

	@Provides
	@Singleton
	public DatabaseOptions databaseOptions(LoomOptions options) {
		return options.getDatabase();
	}
}
