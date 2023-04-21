package io.metaloom.loom.db.jooq.pool;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

import io.metaloom.loom.api.options.DatabaseOptions;
import io.metaloom.loom.db.jooq.test.dagger.DaggerTestComponent;
import io.metaloom.loom.db.jooq.test.dagger.TestComponent;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.test.TestEnvHelper;
import io.metaloom.test.container.provider.client.TestDatabaseProvider;
import io.metaloom.test.container.provider.common.config.ProviderConfig;
import io.metaloom.test.container.provider.model.DatabasePoolResponse;

/**
 * Example implementation for a custom pool setup operation.
 */
public class PoolSetupAction {

	public static void main(String[] args) throws Exception {

		ProviderConfig config = TestEnvHelper.prepareProvider();

		String templateDBName = "loom_dev";

		// 1. Replace the old database with an empty one.
		// The settings will be taken from the database settings
		// which were defined in the testdb-maven-plugin section of your pom.xml
		TestDatabaseProvider.dropCreatePostgreSQLDatabase(templateDBName);

		// 2. Now setup your tables using the flyway migration.
		String url = config.getPostgresql().jdbcUrl(templateDBName);
		String user = config.getPostgresql().getUsername();
		String password = config.getPostgresql().getPassword();
		Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
		MigrateResult result = flyway.migrate();

		System.out.println(result.success ? "Flyway migration OK" : "Flyway migration Failed");

		// 3. Now add some test data
		DatabaseOptions options = new DatabaseOptions();
		options.setDatabaseName(templateDBName);
		options.setHost(config.getPostgresql().getHost());
		options.setPort(config.getPostgresql().getPort());
		options.setPassword(config.getPostgresql().getPassword());
		options.setUsername(config.getPostgresql().getUsername());
		TestComponent component = DaggerTestComponent.builder().configuration(options).build();
		LoomUser adminUser = component.userDao().createUser("admin");
		component.userDao().storeUser(adminUser);
		LoomUser joeDoeUser = component.userDao().createUser("joedoe");
		component.userDao().storeUser(joeDoeUser);

		// 4. Now recreate the dummy pool. The pool will provide the new databases for our tests.
		DatabasePoolResponse response = TestDatabaseProvider.createPool("loom-dev", templateDBName);
		System.out.println("\nPool Created: " + response.toString());

		// 5. Now run your unit tests and happy testing
	}
}
