package io.metaloom.loom.db.jooq.extension;

import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqExtensionDao;
import io.metaloom.loom.db.model.extension.LoomExtension;
import io.metaloom.loom.db.model.extension.LoomExtensionDao;

@Singleton
public class ExtensionDaoImpl extends AbstractJooqDao<JooqExtensionDao> implements LoomExtensionDao {

	@Inject
	public ExtensionDaoImpl(JooqExtensionDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public LoomExtension createExtension(String url, Consumer<LoomExtension> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomExtension loadExtension(UUID uuid) {
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
