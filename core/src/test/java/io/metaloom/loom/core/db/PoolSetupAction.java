package io.metaloom.loom.core.db;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

import io.metaloom.loom.api.options.DatabaseOptions;
import io.metaloom.loom.api.options.LoomOptions;
import io.metaloom.loom.auth.AuthenticationService;
import io.metaloom.loom.core.dagger.DaggerLoomCoreComponent;
import io.metaloom.loom.core.dagger.LoomCoreComponent;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.perm.Permission;
import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;
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
		initalizeDatabase(component);

		// 4. Now recreate the dummy pool. The pool will provide the new databases for our tests.
		DatabasePoolResponse response = TestDatabaseProvider.createPool("loom-dev", templateDBName);
		System.out.println("\nPool Created: " + response.toString());

		// 5. Now run your unit tests and happy testing
	}

	private static void initalizeDatabase(LoomCoreComponent component) {
		DaoCollection daos = component.daos();
		GroupDao groupDao = daos.groupDao();
		UserDao userDao = daos.userDao();
		RoleDao roleDao = daos.roleDao();
		PermissionDao permissionDao = daos.permissionDao();
		AuthenticationService authService = component.authService();

		// User
		User adminUser = userDao.createUser("admin");
		adminUser.setPasswordHash(authService.encodePassword("finger"));
		userDao.storeUser(adminUser);

		// Group + Assign User to Group
		Group group = groupDao.createGroup("test-group");
		groupDao.storeGroup(group);
		groupDao.addUserToGroup(group, adminUser);

		// Role + Assign Role to Group + Role Permission
		Role role = roleDao.createRole("test-role", adminUser.getUuid());
		roleDao.storeRole(role);
		groupDao.addRoleToGroup(group, role);
		permissionDao.grantRolePermission(role.getUuid(), Permission.READ_USER, "test");

		// Second user
		User joeDoeUser = userDao.createUser("joedoe");
		joeDoeUser.setPasswordHash(authService.encodePassword("finger"));
		userDao.storeUser(joeDoeUser);
		permissionDao.grantUserPermission(joeDoeUser.getUuid(), Permission.READ_USER, "test");
		

	}
}
