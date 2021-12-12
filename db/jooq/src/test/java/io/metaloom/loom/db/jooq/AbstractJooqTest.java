package io.metaloom.loom.db.jooq;

import javax.sql.DataSource;

import org.junit.ClassRule;
import org.junit.Rule;

import io.metaloom.loom.db.jooq.test.dagger.JooqTestContext;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.user.LoomUserDao;

public abstract class AbstractJooqTest {

	@Rule
	@ClassRule
	public static JooqTestContext context = new JooqTestContext();

	protected DataSource dataSource() {
		return context.dataSource();
	}

	protected LoomUserDao userDao() {
		return context.userDao();
	}

	protected GroupDao groupDao() {
		return context.groupDao();
	}

}
