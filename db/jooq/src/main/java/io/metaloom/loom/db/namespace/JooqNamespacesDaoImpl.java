package io.metaloom.loom.db.namespace;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.NamespaceDao;
import io.reactivex.Maybe;

public class JooqNamespacesDaoImpl extends AbstractJooqDao implements NamespacesDao {

	private final NamespaceDao delegate;

	protected JooqType getType() {
		return JooqType.NAMESPACE;
	}

	public JooqNamespacesDaoImpl(NamespaceDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Namespace> loadNamespace(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqNamespaceImpl.class);
	}

	@Override
	public void deleteNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		delegate.deleteById(namespace.getUuid());
	}

	@Override
	public Namespace createNamespace() {
		io.metaloom.loom.db.jooq.tables.pojos.Namespace namespace = new io.metaloom.loom.db.jooq.tables.pojos.Namespace();
		delegate.insert(namespace);
		return new JooqNamespaceImpl(namespace);
	}

	@Override
	public void updateNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Namespace jooqNamespace = unwrap(namespace);
		delegate.update(jooqNamespace);
	}

	@Override
	public void storeNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		delegate.update(unwrap(namespace));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
