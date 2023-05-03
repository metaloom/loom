package io.metaloom.loom.core.db;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

import io.metaloom.loom.api.options.DatabaseOptions;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.auth.AuthenticationService;
import io.metaloom.loom.core.dagger.DaggerLoomCoreComponent;
import io.metaloom.loom.core.dagger.LoomCoreComponent;
import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.asset.AssetDao;
import io.metaloom.loom.db.model.asset.BinaryDao;
import io.metaloom.loom.db.model.cluster.ClusterDao;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.library.LibraryDao;
import io.metaloom.loom.db.model.perm.Permission;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.task.TaskDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;
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
		LoomOptions loomOptions = new LoomOptions();
		loomOptions.getAuth().setKeystorePassword("test");
		DatabaseOptions dbOptions = loomOptions.getDatabase();
		dbOptions.setDatabaseName(templateDBName);
		dbOptions.setHost(config.getPostgresql().getHost());
		dbOptions.setPort(config.getPostgresql().getPort());
		dbOptions.setPassword(config.getPostgresql().getPassword());
		dbOptions.setUsername(config.getPostgresql().getUsername());

		LoomCoreComponent component = DaggerLoomCoreComponent.builder().configuration(loomOptions).build();
		TestFixtureProvider.setup(component);

		// 4. Now recreate the dummy pool. The pool will provide the new databases for our tests.
		DatabasePoolResponse response = TestDatabaseProvider.createPool("loom-dev", templateDBName);
		System.out.println("\nPool Created: " + response.toString());

		// 5. Now run your unit tests and happy testing
	}

}
