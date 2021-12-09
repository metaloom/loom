package io.metaloom.loom.db.namespace;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.NamespaceDao;
import io.metaloom.loom.db.jooq.tables.pojos.Namespace;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqNamespaceDaoImpl extends NamespaceDao implements LoomNamespaceDao {

	@Inject
	public JooqNamespaceDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.NAMESPACE;
	// }

	@Override
	public Maybe<? extends LoomNamespace> loadNamespace(UUID uuid) {
		return wrap(findOneById(uuid), JooqNamespaceImpl.class);
	}

	@Override
	public Completable deleteNamespace(UUID uuid) {
		Objects.requireNonNull(uuid, "Namespace uuid must not be null");
		return deleteById(uuid).ignoreElement();
	}

	@Override
	public Single<? extends LoomNamespace> createNamespace(String name) {
		Namespace namespace = new Namespace();
		namespace.setName(name);
		return insertReturningPrimary(namespace).map(pk -> new JooqNamespaceImpl(namespace.setUuid(pk)));
	}

	@Override
	public Completable updateNamespace(LoomNamespace namespace) {
		Objects.requireNonNull(namespace, "Namespace must not be null");
		Namespace jooqNamespace = unwrap(namespace);
		return update(jooqNamespace).ignoreElement();
	}

	@Override
	public Observable<LoomTag> loadTags(LoomNamespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(LoomNamespace namespace, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable removeTag(LoomNamespace namespace, LoomTag tag) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
