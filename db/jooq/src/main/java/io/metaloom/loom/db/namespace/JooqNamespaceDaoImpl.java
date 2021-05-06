package io.metaloom.loom.db.namespace;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqNamespaceDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.NamespaceDao implements NamespaceDao {


	@Inject
	public JooqNamespaceDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

//	protected JooqType getType() {
//		return JooqType.NAMESPACE;
//	}

	@Override
	public Maybe<? extends Namespace> loadNamespace(UUID uuid) {
		return wrap(findOneById(uuid), JooqNamespaceImpl.class);
	}

	@Override
	public Completable deleteNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		return deleteById(namespace.getUuid()).ignoreElement();
	}

	@Override
	public Single<? extends Namespace> createNamespace(String name) {
		io.metaloom.loom.db.jooq.tables.pojos.Namespace namespace = new io.metaloom.loom.db.jooq.tables.pojos.Namespace();
		namespace.setName(name);
		return insertReturningPrimary(namespace).map(pk -> new JooqNamespaceImpl(namespace.setUuid(pk)));
	}

	@Override
	public void updateNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Namespace jooqNamespace = unwrap(namespace);
		update(jooqNamespace);
	}

	@Override
	public void storeNamespace(Namespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		update(unwrap(namespace));
	}

	@Override
	public Observable<Tag> loadTags(Namespace namespace) {
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
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
