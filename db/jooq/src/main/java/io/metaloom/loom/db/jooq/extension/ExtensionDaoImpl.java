package io.metaloom.loom.db.jooq.extension;

import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.extension.LoomExtension;
import io.metaloom.loom.db.model.extension.LoomExtensionDao;

@Singleton
public class ExtensionDaoImpl extends AbstractDao implements LoomExtensionDao {

	@Inject
	public ExtensionDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
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
