package io.metaloom.loom.db.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.impl.DaoCollectionImpl;

@Module
public abstract class DBBindModule {

	@Binds
	abstract LoomDaoCollection daoCollection(DaoCollectionImpl collection);
}
