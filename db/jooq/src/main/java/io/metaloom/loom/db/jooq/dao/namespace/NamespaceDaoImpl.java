package io.metaloom.loom.db.jooq.dao.namespace;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqNamespaceDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqNamespace;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.tag.Tag;

@Singleton
public class NamespaceDaoImpl extends AbstractJooqDao<JooqNamespaceDao> implements NamespaceDao {

	@Inject
	public NamespaceDaoImpl(JooqNamespaceDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Namespace loadNamespace(UUID uuid) {
		return wrap(dao().findById(uuid));
	}

	
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
	public Stream<Tag> loadTags(Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Namespace namespace, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(Namespace namespace, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public Namespace createNamespace(String name) {
		JooqNamespace jooq = new JooqNamespace();
		jooq.setUuid(UUID.randomUUID());
		jooq.setName(name);
		return wrap(jooq);
	}

	@Override
	public void deleteNamespace(UUID uuid) {
		Objects.requireNonNull(uuid, "Namespace uuid must not be null");
		dao().deleteById(uuid);
	}

	@Override
	public void storeNamespace(Namespace namespace) {
		JooqNamespace jooq = unwrap(namespace);
		dao().insert(jooq);
	}

	@Override
	public void updateNamespace(Namespace namespace) {
		JooqNamespace jooq = unwrap(namespace);
		dao().update(jooq);
	}
}
