package io.metaloom.loom.db.jooq.user;

import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.Rule;
import org.junit.Test;

import io.metaloom.loom.db.flyway.dagger.FlywayModule;
import io.metaloom.loom.db.jooq.LoomPostgreSQLContainer;
import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqUser;

public class PoolingTest {

	@Rule
	public LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	@Test
	public void testPooling() {
		new FlywayModule().flyway(container.getOptions()).migrate();
		DataSource ds = new JooqModule().dataSource(container.getOptions());
		DSLContext ctx = DSL.using(ds, SQLDialect.POSTGRES);

		JooqUserDao dao = new JooqUserDao(ctx.configuration());

		JooqUser u = new JooqUser();
		u.setUuid(UUID.randomUUID());
		u.setUsername("dummy");
		dao.insert(u);

		List<JooqUser> us = dao.findAll();
		for (JooqUser cu : us) {
			System.out.println(cu.getUuid() + " " + cu.getUsername());
		}

	}

}
