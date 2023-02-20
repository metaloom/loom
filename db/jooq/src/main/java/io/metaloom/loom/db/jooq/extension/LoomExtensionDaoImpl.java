package io.metaloom.loom.db.jooq.extension;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.ExtensionDao;
import io.metaloom.loom.db.model.extension.LoomExtension;
import io.metaloom.loom.db.model.extension.LoomExtensionDao;

@Singleton
public class LoomExtensionDaoImpl extends AbstractDao implements LoomExtensionDao {

	private final ExtensionDao dao;

	@Inject
	public LoomExtensionDaoImpl(ExtensionDao dao, DSLContext ctx) {
		super(ctx);
		this.dao = dao;
	}

	// protected JooqType getType() {
	// return JooqType.EXTENSION;
	// }

	@Override
	public LoomExtension loadExtension(UUID uuid) {
		return wrap(dao.findById(uuid), LoomExtensionImpl.class);
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
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public LoomExtension createExtension(String url, Consumer<LoomExtension> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateExtension(LoomExtension extension) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteExtension(LoomExtension extension) {
		// TODO Auto-generated method stub
	}
}
