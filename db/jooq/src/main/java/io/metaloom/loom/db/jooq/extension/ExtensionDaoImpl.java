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
public class ExtensionDaoImpl extends AbstractJooqDao<JooqExtensionDao> implements ExtensionDao {

	@Inject
	public ExtensionDaoImpl(JooqExtensionDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Extension createExtension(String url, Consumer<Extension> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Extension loadExtension(UUID uuid) {
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
