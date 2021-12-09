package io.metaloom.loom.db.jooq.user;

import static io.metaloom.loom.db.jooq.tables.Users.USERS;

import java.util.List;
import java.util.UUID;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.junit.Rule;
import org.junit.Test;

import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.AbstractDaoTest;
import io.metaloom.loom.db.jooq.LoomPostgreSQLContainer;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import reactor.core.publisher.Flux;

public class UserDaoTest extends AbstractDaoTest {

	@Rule
	public LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	@Test
	public void testBasics() {

		new FlywayModule().flyway(container.getOptions()).migrate();
		System.out.println(container.getOptions().getJdbcUrl());
		ConnectionFactory connectionFactory = ConnectionFactories.get(
			ConnectionFactoryOptions
				.parse("r2dbc:postgresql://" + container.getHost() + ":" + container.getPort() + "/" + container.getDatabaseName())
				.mutate()
				.option(ConnectionFactoryOptions.USER, container.getUsername())
				.option(ConnectionFactoryOptions.PASSWORD, container.getPassword())
				.build());

		DSLContext ctx = DSL.using(connectionFactory);

		Flux<Record1<UUID>> f = Flux.from(ctx.insertInto(USERS,
			USERS.UUID, USERS.USERNAME, USERS.FIRSTNAME, USERS.LASTNAME)
			.values(UUID.randomUUID(), "joedoe", "Joe", "Doe")
			.returningResult(USERS.UUID));

		f.blockFirst();

		// Completable.fromCompletionStage(stage).blockingAwait();

		List<String> users = Flux.from(ctx.select(USERS.FIRSTNAME, USERS.LASTNAME)
			.from(USERS))
			.map(r -> r.get(USERS.FIRSTNAME) + " " + r.get(USERS.LASTNAME))
			.collectList()
			.block();

		for (String u : users) {
			System.out.println(u);
		}
	}
}
