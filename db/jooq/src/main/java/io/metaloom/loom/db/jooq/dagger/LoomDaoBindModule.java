package io.metaloom.loom.db.jooq.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.jooq.dao.user.JooqLoomUserDaoImpl;
import io.metaloom.loom.db.model.user.LoomUserDao;

@Module
public abstract class LoomDaoBindModule {

	@Binds
	abstract LoomUserDao bindLoomUserDao(JooqLoomUserDaoImpl e);
}
