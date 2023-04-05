package io.metaloom.loom.db.jooq.user;

import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.db.jooq.dagger.JooqModule;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqUser;
import io.metaloom.loom.test.LoomProviderExtension;

public class PoolingTest {

	@RegisterExtension
	public static LoomProviderExtension provider = LoomProviderExtension.create();

	@Test
	public void testPooling() {
		DataSource ds = new JooqModule().dataSource(provider.options());
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
