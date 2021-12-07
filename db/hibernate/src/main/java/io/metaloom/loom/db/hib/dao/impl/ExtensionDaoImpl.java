package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.extension.Extension;
import io.metaloom.loom.db.model.extension.ExtensionDao;
import io.metaloom.loom.db.model.extension.impl.ExtensionImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class ExtensionDaoImpl extends AbstractDao implements ExtensionDao {

	private static final String TYPE_NAME = "Extension";

	@Inject
	public ExtensionDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Single<? extends Extension> createExtension(String url, Consumer<Extension> modifier) {
		return Single.defer(() -> {
			Extension extension = new ExtensionImpl(url);
			if (modifier != null) {
				modifier.accept(extension);
			}
			return persistAndReturnElement(extension);
		});
	}

	@Override
	public Maybe<? extends Extension> loadExtension(UUID uuid) {
		return loadByUuid(ExtensionImpl.class, uuid);
	}

	@Override
	public Completable updateExtension(Extension extension) {
		return persistElement(extension);
	}

	@Override
	public Completable deleteExtension(Extension extension) {
		return deleteElement(extension);
	}
}
