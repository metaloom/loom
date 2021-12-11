package io.metaloom.loom.db.jooq.user;

import static io.metaloom.loom.db.jooq.tables.User.USER;

import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Rule;
import org.junit.Test;

import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.jooq.LoomPostgreSQLContainer;
import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import reactor.core.publisher.Flux;

public class NonReactiveGeneratedDaoTest extends AbstractJooqTest {

	@Rule
	public LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	@Test
	public void testBasics() {

		new FlywayModule().flyway(container.getOptions()).migrate();
		System.out.println(container.getOptions().getJdbcUrl());

		DataSource datasource = new JooqModule().dataSource(container.getOptions());

		DSLContext ctx = DSL.using(datasource, SQLDialect.POSTGRES);

		Flux<Record1<UUID>> f = Flux.from(ctx.insertInto(USER,
			USER.UUID, USER.USERNAME, USER.FIRSTNAME, USER.LASTNAME)
			.values(UUID.randomUUID(), "joedoe", "Joe", "Doe")
			.returningResult(USER.UUID));

		f.blockFirst();

		UserDao dao = new UserDao(ctx.configuration());

		List<User> users = dao.fetchByUsername("joedoe");
		for (User u : users) {
			System.out.println("Found: " + u.getUsername() + " " + u.getUuid());
		}

	}
}
