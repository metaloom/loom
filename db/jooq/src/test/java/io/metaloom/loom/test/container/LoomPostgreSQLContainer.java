package io.metaloom.loom.test.container;

import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Preconfigured {@link PostgreSQLContainer}
 */
public class LoomPostgreSQLContainer extends PostgreSQLContainer<LoomPostgreSQLContainer> {

	public static final String DEFAULT_IMAGE = "postgres:13.2";

	public LoomPostgreSQLContainer() {
		super(DEFAULT_IMAGE);
		withDatabaseName("loom");
		withUsername("sa");
		withPassword("sa");
	}

	public int getPort() {
		return getFirstMappedPort();
	}
}
