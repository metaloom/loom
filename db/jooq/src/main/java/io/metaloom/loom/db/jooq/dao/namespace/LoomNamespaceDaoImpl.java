package io.metaloom.loom.db.jooq.dao.namespace;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.NamespaceDao;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.namespace.LoomNamespaceDao;
import io.metaloom.loom.db.model.tag.LoomTag;

@Singleton
public class LoomNamespaceDaoImpl extends AbstractDao implements LoomNamespaceDao {

	private NamespaceDao dao;

	@Inject
	public LoomNamespaceDaoImpl(NamespaceDao dao, DSLContext ctx) {
		super(ctx);
		this.dao = dao;
	}

	@Override
	public LoomNamespace loadNamespace(UUID uuid) {
		return wrap(dao.findById(uuid), LoomNamespaceImpl.class);
	}

	// @Override
	// public Completable deleteNamespace(UUID uuid) {
	// Objects.requireNonNull(uuid, "Namespace uuid must not be null");
	// return deleteById(uuid).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomNamespace> createNamespace(String name) {
	// Namespace namespace = new Namespace();
	// namespace.setName(name);
	// return insertReturningPrimary(namespace).map(pk -> new LoomNamespaceImpl(namespace.setUuid(pk)));
	// }
	//
	// @Override
	// public Completable updateNamespace(LoomNamespace namespace) {
	// Objects.requireNonNull(namespace, "Namespace must not be null");
	// Namespace jooqNamespace = unwrap(namespace);
	// return update(jooqNamespace).ignoreElement();
	// }

	@Override
	public Stream<LoomTag> loadTags(LoomNamespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(LoomNamespace namespace, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(LoomNamespace namespace, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public LoomNamespace createNamespace(String name, Consumer<LoomNamespace> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNamespace(UUID uuid) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateNamespace(LoomNamespace namespace) {
	}
}
