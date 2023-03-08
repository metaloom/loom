package io.metaloom.loom.db.jooq.user;

import java.util.List;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Rule;
import org.junit.Test;

import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.jooq.LoomPostgreSQLContainer;
import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqUser;

public class NonReactiveGeneratedDaoTest extends AbstractJooqTest {

	@Rule
	public LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	@Test
	public void testBasics() {

		new FlywayModule().flyway(container.getOptions()).migrate();
		System.out.println(container.getOptions().getJdbcUrl());

		DataSource datasource = new JooqModule().dataSource(container.getOptions());

		DSLContext ctx = DSL.using(datasource, SQLDialect.POSTGRES);
//
//		Flux<Record1<UUID>> f = Flux.from(ctx.insertInto(USER,
//			USER.UUID, USER.USERNAME, USER.FIRSTNAME, USER.LASTNAME)
//			.values(UUID.randomUUID(), "joedoe", "Joe", "Doe")
//			.returningResult(USER.UUID));
//
//		f.blockFirst();

		JooqUserDao dao = new JooqUserDao(ctx.configuration());

		List<JooqUser> users = dao.fetchByUsername("joedoe");
		for (JooqUser u : users) {
			System.out.println("Found: " + u.getUsername() + " " + u.getUuid());
		}

	}
}
