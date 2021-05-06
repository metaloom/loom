package io.metaloom.loom.db.extension;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.reactivex.Maybe;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqExtensionDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.ExtensionDao implements ExtensionDao {

	@Inject
	public JooqExtensionDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.EXTENSION;
	// }

	@Override
	public Maybe<? extends Extension> loadExtension(UUID uuid) {
		return wrap(findOneById(uuid), JooqExtensionImpl.class);
	}

	@Override
	public void deleteExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		deleteById(extension.getUuid());
	}

	@Override
	public Extension createExtension() {
		io.metaloom.loom.db.jooq.tables.pojos.Extension extension = new io.metaloom.loom.db.jooq.tables.pojos.Extension();
		insert(extension);
		return new JooqExtensionImpl(extension);
	}

	@Override
	public void updateExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Extension jooqExtension = unwrap(extension);
		update(jooqExtension);
	}

	@Override
	public void storeExtension(Extension extension) {
		Objects.requireNonNull(extension, "Extension must not be null");
		update(unwrap(extension));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
