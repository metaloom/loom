package io.metaloom.loom.db.jooq.dao.role;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.extension.Extension;
import io.metaloom.loom.db.model.extension.ExtensionDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class ExtensionDaoImpl extends AbstractDao implements ExtensionDao {

	@Inject
	public ExtensionDaoImpl() {
	}

	@Override
	public Completable clear() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Extension> createExtension(String url, Consumer<Extension> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Extension> loadExtension(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateExtension(Extension extension) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteExtension(Extension extension) {
		// TODO Auto-generated method stub
		return null;
	}

}
