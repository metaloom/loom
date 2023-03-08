package io.metaloom.loom.db.jooq.user;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.Rule;
import org.junit.Test;

import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.metaloom.loom.test.container.LoomPostgreSQLContainer;
import io.r2dbc.spi.ConnectionFactory;

public class UserDaoTest extends AbstractJooqTest {

	@Rule
	public LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	@Test
	public void testBasics() {

		new FlywayModule().flyway(container.getOptions()).migrate();
		System.out.println(container.getOptions().getJdbcUrl());
		ConnectionFactory connectionFactory =  new JooqModule().r2dbcConnectionFactory(container.getOptions());

		DSLContext ctx = DSL.using(connectionFactory);
//
//		Flux<Record1<UUID>> f = Flux.from(ctx.insertInto(USER,
//			USER.UUID, USER.USERNAME, USER.FIRSTNAME, USER.LASTNAME)
//			.values(UUID.randomUUID(), "joedoe", "Joe", "Doe")
//			.returningResult(USER.UUID));
//
//		f.blockFirst();

		// Completable.fromCompletionStage(stage).blockingAwait();
//
//		List<String> users = Flux.from(ctx.select(USER.FIRSTNAME, USER.LASTNAME)
//			.from(USER))
//			.map(r -> r.get(USER.FIRSTNAME) + " " + r.get(USER.LASTNAME))
//			.collectList()
//			.block();
//
//		for (String u : users) {
//			System.out.println(u);
//		}
	}
}
