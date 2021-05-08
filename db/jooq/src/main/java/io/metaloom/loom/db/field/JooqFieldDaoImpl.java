package io.metaloom.loom.db.field;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.FieldDao;
import io.metaloom.loom.db.jooq.tables.pojos.Field;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqFieldDaoImpl extends FieldDao implements LoomFieldDao {

	@Inject
	public JooqFieldDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.FIELD;
	// }

	@Override
	public Maybe<? extends LoomField> loadField(UUID uuid) {
		return wrap(findOneById(uuid), JooqFieldImpl.class);
	}

	@Override
	public Completable deleteField(LoomField content) {
		Objects.requireNonNull(content, "Field must not be null");
		return deleteById(content.getUuid()).ignoreElement();
	}

	@Override
	public LoomField createField() {
		Field content = new Field();
		insert(content);
		return new JooqFieldImpl(content);
	}

	@Override
	public Completable updateField(LoomField content) {
		Objects.requireNonNull(content, "Field must not be null");
		Field jooqField = unwrap(content);
		return update(jooqField).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
