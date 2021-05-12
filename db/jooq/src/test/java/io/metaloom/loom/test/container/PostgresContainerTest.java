package io.metaloom.loom.test.container;

import org.junit.ClassRule;
import org.junit.Test;

import io.metaloom.loom.db.flyway.FlywayHelper;
import io.metaloom.loom.db.namespace.LoomNamespaceDao;
import io.metaloom.loom.options.DatabaseOptions;
import io.metaloom.loom.options.LoomOptions;
import io.metaloom.loom.test.dagger.DaggerLoomJooqTestComponent;
import io.metaloom.loom.test.dagger.LoomJooqTestComponent;

public class PostgresContainerTest {

	@ClassRule
	public static LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	@Test
	public void testSQL() {
		// Prepare settings
		LoomOptions options = new LoomOptions();
		DatabaseOptions dbOptions = options.getDatabase();
		dbOptions.setPort(container.getPort());
		dbOptions.setHost(container.getContainerIpAddress());
		dbOptions.setUsername(container.getUsername());
		dbOptions.setPassword(container.getPassword());
		dbOptions.setDatabaseName(container.getDatabaseName());

		// Prepare the database
		FlywayHelper.migrate(dbOptions);

		// Now setup loom
		LoomJooqTestComponent loomTest = DaggerLoomJooqTestComponent.builder().configuration(options).build();

		// Use the dao
		LoomNamespaceDao dao = loomTest.daos().getNamespaceDao();
		dao.createNamespace("test123").blockingGet();
	}
}
