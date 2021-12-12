package io.metaloom.loom.db.jooq.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.jooq.dao.group.GroupDaoImpl;
import io.metaloom.loom.db.jooq.dao.user.LoomUserDaoImpl;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.user.LoomUserDao;

@Module
public abstract class LoomDaoBindModule {

	@Binds
	abstract LoomUserDao bindLoomUserDao(LoomUserDaoImpl e);
	
	@Binds
	abstract GroupDao bindGroupDao(GroupDaoImpl e);
}
	