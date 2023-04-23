package io.metaloom.loom.db.dagger;

import dagger.Binds;
import dagger.Module;
import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.impl.DaoCollectionImpl;

@Module
public abstract class DBBindModule {

	@Binds
	abstract DaoCollection daoCollection(DaoCollectionImpl collection);
}
