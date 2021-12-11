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
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.pojos.User;

public class PoolingTest {

	@Rule
	public LoomPostgreSQLContainer container = new LoomPostgreSQLContainer();

	@Test
	public void testPooling() {
		new FlywayModule().flyway(container.getOptions()).migrate();
		DataSource ds = new JooqModule().dataSource(container.getOptions());
		DSLContext ctx = DSL.using(ds, SQLDialect.POSTGRES);

		UserDao dao = new UserDao(ctx.configuration());

		User u = new User();
		u.setUuid(UUID.randomUUID());
		u.setUsername("dummy");
		dao.insert(u);

		List<User> us = dao.findAll();
		for (User cu : us) {
			System.out.println(cu.getUuid() + " " + cu.getUsername());
		}

	}

}
