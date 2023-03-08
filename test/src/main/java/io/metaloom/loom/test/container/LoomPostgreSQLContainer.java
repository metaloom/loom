package io.metaloom.loom.test.container;

import org.testcontainers.containers.PostgreSQLContainer;

import io.metaloom.loom.api.options.DatabaseOptions;

/**
 * Preconfigured {@link LoomPostgreSQLContainer}
 */
public class LoomPostgreSQLContainer extends PostgreSQLContainer<LoomPostgreSQLContainer> {

	public static final String DEFAULT_IMAGE = "postgres:13.2";

	public LoomPostgreSQLContainer() {
		super(DEFAULT_IMAGE);
		withDatabaseName("postgres");
		withUsername("sa");
		withPassword("sa");
	}

	public int getPort() {
		return getFirstMappedPort();
	}

	public DatabaseOptions getOptions() {
		DatabaseOptions options = new DatabaseOptions();
		options.setPort(getPort());
		options.setHost(getContainerIpAddress());
		options.setUsername(getUsername());
		options.setPassword(getPassword());
		options.setDatabaseName(getDatabaseName());
		return options;
	}
}
