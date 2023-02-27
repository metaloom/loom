package io.metaloom.loom.db.jooq.test.dagger;

import javax.sql.DataSource;


import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.jooq.LoomPostgreSQLContainer;
import io.metaloom.loom.db.model.group.LoomGroupDao;
import io.metaloom.loom.db.model.user.LoomUserDao;

public class JooqTestContext extends TestWatcher {

	public static final Logger log = LoggerFactory.getLogger(JooqTestContext.class);

	private LoomPostgreSQLContainer container;

	private TestComponent component;

	@Override
	protected void starting(Description description) {
		log.info("Starting test context");
		if (description.isSuite()) {
			log.info("Preparing env");
			container = new LoomPostgreSQLContainer();
			container.start();

			component = DaggerTestComponent.builder().configuration(container.getOptions()).build();
			component.flyway().migrate();
		} else {

		}
	}

	@Override
	protected void finished(Description description) {
		log.info("Stopping test context");
		if (description.isSuite()) {
			container.stop();
		} else {

		}
	}

	public DataSource dataSource() {
		return component.dataSource();
	}

	public LoomUserDao userDao() {
		return component.userDao();
	}

	public LoomGroupDao groupDao() {
		return component.groupDao();
	}

}