package io.metaloom.loom.db.flyway;

import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.options.DatabaseOptions;

public final class FlywayHelper {

	private FlywayHelper() {
	}

	public static void migrate(DatabaseOptions options) {
		new FlywayModule().flyway(options).migrate();
	}
}
