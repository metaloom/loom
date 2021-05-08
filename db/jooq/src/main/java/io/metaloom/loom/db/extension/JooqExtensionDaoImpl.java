package io.metaloom.loom.db.extension;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.group.JooqGroupImpl;
import io.metaloom.loom.db.jooq.tables.daos.ExtensionDao;
import io.metaloom.loom.db.jooq.tables.pojos.Extension;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqExtensionDaoImpl extends ExtensionDao implements LoomExtensionDao {

	@Inject
	public JooqExtensionDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.EXTENSION;
	// }

	@Override
	public Maybe<? extends LoomExtension> loadExtension(UUID uuid) {
		return wrap(findOneById(uuid), JooqExtensionImpl.class);
	}

	@Override
	public Completable deleteExtension(LoomExtension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		return deleteById(extension.getUuid()).ignoreElement();
	}

	@Override
	public Single<? extends LoomExtension> createExtension() {
		Extension extension = new Extension();
		return insertReturningPrimary(extension).map(pk -> new JooqExtensionImpl(extension.setUuid(pk)));
	}

	@Override
	public Completable updateExtension(LoomExtension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		Extension jooqExtension = unwrap(extension);
		return update(jooqExtension).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}
}
