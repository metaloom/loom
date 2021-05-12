package io.metaloom.loom.test.container;

import org.junit.BeforeClass;
import org.junit.ClassRule;

import io.metaloom.loom.db.flyway.FlywayHelper;
import io.metaloom.loom.options.LoomOptions;
import io.metaloom.loom.test.dagger.DaggerLoomJooqTestComponent;
import io.metaloom.loom.test.dagger.LoomJooqTestComponent;

public class AbstractLoomContainerTest {

	@ClassRule
	public static LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	private static LoomJooqTestComponent loomComponent;

	@BeforeClass
	public static void setupContainer() {
		// Prepare settings
		LoomOptions options = new LoomOptions();
		options.setDatabase(container.getOptions());

		// Prepare the database
		FlywayHelper.migrate(container.getOptions());

		// Now setup loom
		loomComponent = DaggerLoomJooqTestComponent.builder()
			.configuration(options).build();

	}

	public static LoomJooqTestComponent component() {
		return loomComponent;
	}
}
