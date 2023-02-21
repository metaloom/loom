package io.metaloom.loom.db.jooq.user;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.Rule;
import org.junit.Test;

import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.jooq.LoomPostgreSQLContainer;
import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.r2dbc.spi.ConnectionFactory;

public class RxDaoTest extends AbstractJooqTest {

	@Rule
	public LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	@Test
	public void testBasics() {

		new FlywayModule().flyway(container.getOptions()).migrate();
		System.out.println(container.getOptions().getJdbcUrl());

		ConnectionFactory connectionFactory = new JooqModule().r2dbcConnectionFactory(container.getOptions());

		DSLContext ctx = DSL.using(connectionFactory);

//		Flux<Record1<UUID>> f = Flux.from(ctx.insertInto(USER,
//			USER.UUID, USER.USERNAME, USER.FIRSTNAME, USER.LASTNAME)
//			.values(UUID.randomUUID(), "joedoe", "Joe", "Doe")
//			.returningResult(USER.UUID));

//		f.blockFirst();

//		UserRxDao dao = new UserRxDao(ctx.configuration());
//
//		List<User> users = dao.fetchByUsername("joedoe");
//		for (User u : users) {
//			System.out.println("Found: " + u.getUsername() + " " + u.getUuid());
//		}
	}
}
