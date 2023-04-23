package io.metaloom.loom.db.jooq.extension;

import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqExtensionDao;
import io.metaloom.loom.db.model.extension.Extension;
import io.metaloom.loom.db.model.extension.ExtensionDao;

@Singleton
public class LoomExtensionDaoImpl extends AbstractJooqDao<JooqExtensionDao> implements ExtensionDao {

	@Inject
	public LoomExtensionDaoImpl(JooqExtensionDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Extension loadExtension(UUID uuid) {
		return wrap(dao().findById(uuid));
	}

	// @Override
	// public Completable deleteExtension(LoomExtension extension) {
	// Objects.requireNonNull(extension, "Extension must not be null");
	// return deleteById(extension.getUuid()).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomExtension> createExtension() {
	// Extension extension = new Extension();
	// return insertReturningPrimary(extension).map(pk -> new LoomExtensionImpl(extension.setUuid(pk)));
	// }
	//
	// @Override
	// public Completable updateExtension(LoomExtension extension) {
	// Objects.requireNonNull(extension, "Extension must not be null");
	// Extension jooqExtension = unwrap(extension);
	// return update(jooqExtension).ignoreElement();
	// }

	@Override
	public Extension createExtension(String url, Consumer<Extension> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateExtension(Extension extension) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteExtension(Extension extension) {
		// TODO Auto-generated method stub
	}
}
