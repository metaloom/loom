package io.metaloom.loom.db.flyway;

import org.flywaydb.core.Flyway;

import io.metaloom.loom.options.DatabaseOptions;

public final class FlywayHelper {

	private FlywayHelper() {
	}

	public static void migrate(DatabaseOptions options) {
		int port = options.getPort();
		String dbName = options.getDatabaseName();
		String user = options.getUsername();
		String password = options.getPassword();
		String url = "jdbc:postgresql://" + options.getHost() + ":" + port + "/" + dbName;
		Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
		flyway.migrate();
	}
}
