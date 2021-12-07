package io.metaloom.loom.db;

import org.flywaydb.core.Flyway;
import org.hibernate.reactive.mutiny.Mutiny.SessionFactory;
import org.junit.Before;
import org.junit.Rule;

import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.hib.dagger.HibernateModule;
import io.vertx.rxjava3.core.Vertx;

public abstract class AbstractDaoTest {

	@Rule
	public LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	protected Vertx rxVertx;

	protected Flyway flyway;

	protected SessionFactory emf;

	@Before
	public void setupDB() {
		System.out.println("---");
		System.out.println(container.getContainerIpAddress() + ":" + container.getPort());
		System.out.println("JDBCUrl: " + container.getJdbcUrl());
		System.out.println("Username: " + container.getUsername());
		System.out.println("Password: " + container.getPassword());
		System.out.println("---");
		this.flyway = new FlywayModule().flyway(container.getOptions());
		flyway.migrate();

		this.rxVertx = Vertx.vertx();
		this.emf = new HibernateModule().sessionFactory(rxVertx, container.getOptions());
	}
}
